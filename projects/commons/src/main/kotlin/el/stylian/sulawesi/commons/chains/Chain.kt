package el.stylian.sulawesi.commons.chains

import java.util.LinkedList

open class Chain {

    protected val chainline: LinkedList<AbstractLink>
    constructor() {
        this.chainline = LinkedList<AbstractLink>()
    }

    private constructor(anotherChainline : LinkedList<AbstractLink>) {
        this.chainline = anotherChainline
    }
    operator fun plus(chainToAppend: Chain) : Chain {
        val newChain = LinkedList<AbstractLink>()
        newChain.addAll(chainline)
        newChain.addAll(chainToAppend.chainline)
        return Chain(newChain)
    }
    fun run() {
        chainline.forEach {
            it.runIt()
        }
    }

}