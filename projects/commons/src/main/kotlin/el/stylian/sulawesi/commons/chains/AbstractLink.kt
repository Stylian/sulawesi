package el.stylian.sulawesi.commons.chains

abstract class AbstractLink {

    private var nextLink : AbstractLink? = null
    operator fun plus(linkToAppend: AbstractLink) : AbstractLink {
        getLast().nextLink = linkToAppend
        return this
    }
    fun getLast(): AbstractLink {
        return next()?.getLast() ?: this
    }
    fun run() {
        execute()
        next()?.run()
    }
    open fun next() = nextLink
    abstract fun execute()

}