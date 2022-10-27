package leetcode

import java.util.*

object GenerateParenthesis {

    private var n: Int = 0
    private var stack: Stack<Char> = Stack()
    private var result: MutableList<String> = mutableListOf()

    @JvmStatic
    fun main(args: Array<String>) {
        println( generateParenthesis(3))
    }

    fun generateParenthesis(n: Int): List<String> {
        this.n = n
        backtrack(0, 0)

        return result
    }

    fun backtrack(openN: Int, closeN: Int) {
        if (openN == n && closeN == n) {
            val string = stack.joinToString(separator = "")
            result.add(string)
        }

        if (openN < n) {
            stack.add('(')
            backtrack(openN + 1, closeN)
            stack.pop()
        }

        if (closeN < openN) {
            stack.add(')')
            backtrack(openN, closeN + 1)
            stack.pop()
        }
    }
}