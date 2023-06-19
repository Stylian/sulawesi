package el.stylian.sulawesi.commons.chains

abstract class AbstractLink<T> {

    var nextLink : AbstractLink<T>? = null
    var previousLink : AbstractLink<T>? = null
    var fallbackLink : AbstractLink<T>? = null

    var  data : T? = null
    operator fun plus(linkToAppend: AbstractLink<T>) : AbstractLink<T> {
        getLast().nextLink = linkToAppend
        linkToAppend.previousLink = this
        return this
    }
    operator fun div(altChain: AbstractLink<T>) : AbstractLink<T> {
        this.fallbackLink = altChain
        return this
    }

    operator fun rangeTo(data: T) : AbstractLink<T> {
        this.data = data
        attachDataToFollowingLinkChain()
        return this
    }
    private fun attachDataToFollowingLinkChain() {
        nextLink?.data = data
        nextLink?.attachDataToFollowingLinkChain()
    }

    private fun findLastFallbackLink(): AbstractLink<T>? {
        return fallbackLink ?: previousLink?.findLastFallbackLink()
    }

    fun getLast(): AbstractLink<T> {
        return next()?.getLast() ?: this
    }
    fun run() {
        build()
        try {
            execute()
            next()?.run()
        }catch(e: Exception) {
            findLastFallbackLink()?.run()
        }
    }
    open fun next() = nextLink

    // this should redirect a fork chain if the condition changes
    fun build() {
        nextLink = next()
    }
    abstract fun execute()

}