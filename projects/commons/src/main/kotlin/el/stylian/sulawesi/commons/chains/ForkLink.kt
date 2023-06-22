package el.stylian.sulawesi.commons.chains

class ForkLink<T>(val condition: () -> Boolean, val chainMain: Link<T>, val chainAlternative : Link<T>) : AbstractLink<T>() {
    constructor( conditionFlag: Boolean, chainMain: Link<T>, chainAlternative : Link<T> )
            : this( { conditionFlag }, chainMain, chainAlternative) {
    }
    init {
        chainMain.previousLink = this
        chainAlternative.previousLink = this
    }
    override fun next(): Link<T> {
        return if (condition.invoke()) chainMain else chainAlternative
    }
}