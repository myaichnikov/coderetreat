package ru.coderetreat.life

import java.util.*

/**
 * @author vladimir
 */
class Field(private val initialState: Array<BooleanArray>) : Cloneable {
    val width = initialState.size
    val height = initialState.get(0).size

    val cells: Array<Pair<Int, Int>> = Array(initialState.size * initialState.get(0).size, {
        it ->
        val x = it % width
        val y = x % height
        Pair(x, y)
    })

    override fun toString(): String {
        return initialState.map { it -> it.map { it -> if (it) "*" else " " }.joinToString("") }
                .joinToString(separator = "\n", prefix = "\n", postfix = "\n")
    }

    override public fun clone(): Field {
        return Field(initialState.map { it -> it.copyOf() }.toTypedArray())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Field

        return toString().equals(other.toString())
    }

    override fun hashCode(): Int {
        return initialState.map { Arrays.hashCode(it) }.reduce { i, j -> i + j }
    }

    fun next(): Field {
        initialState.map { it -> it.ma }
    }
}