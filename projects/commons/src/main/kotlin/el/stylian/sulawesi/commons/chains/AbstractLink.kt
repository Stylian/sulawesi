package el.stylian.sulawesi.commons.chains

abstract class AbstractLink<T> {

    var nextLink : AbstractLink<T>? = null
    var previousLink : AbstractLink<T>? = null

    var  data : T? = null
    operator fun plus(linkToAppend: AbstractLink<T>) : AbstractLink<T> {
        getLast().nextLink = linkToAppend
        linkToAppend.previousLink = this
        return this
    }
    operator fun rangeTo(data: T) : AbstractLink<T> {
        this.data = data
        attachDataToFollowingLink()
        return this
    }
    fun attachDataToFollowingLink() {
        nextLink?.data = data
        nextLink?.attachDataToFollowingLink()
    }

    fun getLast(): AbstractLink<T> {
        return next()?.getLast() ?: this
    }
    fun run() {
        build()
        execute()
        next()?.run()
    }
    open fun next() = nextLink

    // this should redirect a fork chain if the condition changes
    fun build() {
        nextLink = next()
    }
    abstract fun execute()

}