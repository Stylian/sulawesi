package el.stylian.sulawesi.commons.chains

class Link(functionToRun: () -> Unit) : AbstractLink(functionToRun) {
    override fun execute() { }
}