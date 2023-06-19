package el.stylian.sulawesi.commons.chains

class CommandLink(private var functionToRun: () -> Unit) : AbstractLink<Nothing>() {

    override fun execute() {
        functionToRun.invoke()
    }
}