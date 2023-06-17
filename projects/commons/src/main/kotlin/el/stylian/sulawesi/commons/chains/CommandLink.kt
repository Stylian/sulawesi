package el.stylian.sulawesi.commons.chains

class CommandLink : AbstractLink {

    private var functionToRun: () -> Unit = { }
    constructor( functionToRun: () -> Unit ) {
        this.functionToRun = functionToRun
    }
    override fun execute() {
        functionToRun.invoke()
    }
}