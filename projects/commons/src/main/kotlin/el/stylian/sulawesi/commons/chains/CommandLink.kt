package el.stylian.sulawesi.commons.chains

class CommandLink<T>(private var functionToRun: () -> Unit) : ExecutableLink<T>() {

    override fun execute() {
        functionToRun.invoke()
    }
}