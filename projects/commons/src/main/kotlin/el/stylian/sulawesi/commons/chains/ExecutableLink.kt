package el.stylian.sulawesi.commons.chains

abstract class ExecutableLink<T> : AbstractLink<T>() {
    override fun onRun() {
        execute()
    }
    abstract fun execute()
}