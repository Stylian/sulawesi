package el.stylian.sulawesi.commons.chains

class ForkLink<T>(val condition: () -> Boolean, val chainMain: AbstractLink<T>, val chainAlternative : AbstractLink<T>) : AbstractLink<T>() {
    constructor( conditionFlag: Boolean, chainMain: AbstractLink<T>, chainAlternative : AbstractLink<T> )
            : this( { conditionFlag }, chainMain, chainAlternative) {
    }
    init {
        chainMain.previousLink = this
        chainAlternative.previousLink = this
    }
    override fun next(): AbstractLink<T> {
        return if (condition.invoke()) chainMain else chainAlternative
    }
    override fun execute() { }
}