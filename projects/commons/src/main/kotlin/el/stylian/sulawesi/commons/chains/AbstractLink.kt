package el.stylian.sulawesi.commons.chains

abstract class AbstractLink<T> {

    var nextLink : AbstractLink<T>? = null
    var previousLink : AbstractLink<T>? = null
    var fallbackLink : AbstractLink<T>? = null

    var  data : T? = null
    operator fun plus(linkToAppend: AbstractLink<T>) : AbstractLink<T> {
        last().nextLink = linkToAppend
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
        next()?.data = data
        next()?.attachDataToFollowingLinkChain()
    }

    private fun lastFallbackLink(): AbstractLink<T>? {
        return fallbackLink ?: previous()?.lastFallbackLink()
    }

    fun run() {
        try {
            execute()
            next()?.run()
        }catch(e: FallbackException) {
            lastFallbackLink()?.run()
        }
    }
    open fun first(): AbstractLink<T> {
        return previous()?.first() ?: this
    }
    open fun last(): AbstractLink<T> {
        return next()?.last() ?: this
    }
    open fun previous() = previousLink
    open fun next() = nextLink
    abstract fun execute()

}