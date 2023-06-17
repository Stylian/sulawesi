package el.stylian.sulawesi.commons.chains

import java.util.*

abstract class AbstractLink {

    var nextLink : AbstractLink? = null
    operator fun plus(linkToAppend: AbstractLink) : AbstractLink {
        getLast().nextLink = linkToAppend
        return this
    }
    fun getLast(): AbstractLink {
        return nextLink?.getLast() ?: this
    }
    fun run() {
        execute()
        nextLink?.run()
    }
    abstract fun execute()

}