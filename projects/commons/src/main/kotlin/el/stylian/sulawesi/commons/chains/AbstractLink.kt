package el.stylian.sulawesi.commons.chains

abstract class AbstractLink<T> : Link<T> {

    override var nextLink: Link<T>? = null
    override var previousLink: Link<T>? = null
    override var fallbackLink: Link<T>? = null

    override var data: T? = null
    override fun run() {
        try {
            onRun()
            next()?.run()
        } catch (e: FallbackException) {
            lastFallbackLink()?.run()
        }
    }

    open fun onRun() {}
    override fun first(): Link<T> {
        return previous()?.first() ?: this
    }

    override fun last(): Link<T> {
        return next()?.last() ?: this
    }

    override fun previous() = previousLink
    override fun next() = nextLink
    override fun lastFallbackLink(): Link<T>? {
        return fallbackLink ?: previous()?.lastFallbackLink()
    }
}