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