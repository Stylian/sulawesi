package el.stylian.sulawesi.commons.chains

abstract class AbstractLink : Chain {

    private var functionToRun: () -> Unit = { }
    protected constructor() {
        chainline.add(this)
    }

    constructor( functionToRun: () -> Unit ) : this() {
        this.functionToRun = functionToRun
    }

    fun runIt() {
        functionToRun.invoke()
        execute()
    }

    abstract fun execute()

}