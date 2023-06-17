package el.stylian.sulawesi.commons.chains

class ForkLink(val condition: () -> Boolean, val chainMain: AbstractLink, val chainAlternative : AbstractLink) : AbstractLink() {
    constructor( conditionFlag: Boolean, chainMain: AbstractLink, chainAlternative : AbstractLink )
            : this( { conditionFlag }, chainMain, chainAlternative) {
    }
    override fun next(): AbstractLink {
        return if (condition.invoke()) chainMain else chainAlternative
    }
    override fun execute() { }
}