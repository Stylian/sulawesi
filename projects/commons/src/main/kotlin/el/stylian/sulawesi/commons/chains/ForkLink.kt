package el.stylian.sulawesi.commons.chains

class ForkLink(val condition: Boolean, val chainMain: AbstractLink, val chainAlternative : AbstractLink) : AbstractLink() {

    override fun next(): AbstractLink {
        return if (condition) chainMain else chainAlternative
    }
    override fun execute() { }
}