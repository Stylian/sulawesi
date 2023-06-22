package el.stylian.sulawesi.commons.chains

interface Link<T> {
    var nextLink: Link<T>?
    var previousLink: Link<T>?
    var fallbackLink: Link<T>?
    var data: T?
    fun first(): Link<T>
    fun last(): Link<T>
    fun previous(): Link<T>?
    fun next(): Link<T>?
    fun lastFallbackLink(): Link<T>?
    fun run()
    operator fun plus(linkToAppend: Link<T>): Link<T> {
        last().nextLink = linkToAppend
        linkToAppend.previousLink = this
        return this
    }

    operator fun div(altChain: Link<T>): Link<T> {
        this.fallbackLink = altChain
        return this
    }

    operator fun rangeTo(data: T): Link<T> {
        this.data = data
        attachDataToFollowingLink()
        return this
    }

    fun attachDataToFollowingLink() {
        next()?.data = data
        next()?.attachDataToFollowingLink()
    }
}