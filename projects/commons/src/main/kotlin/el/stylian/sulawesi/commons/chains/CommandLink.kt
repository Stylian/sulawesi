package el.stylian.sulawesi.commons.chains

class CommandLink<T>(private var functionToRun: () -> Unit) : AbstractLink<T>() {

    override fun execute() {
        functionToRun.invoke()
    }
}