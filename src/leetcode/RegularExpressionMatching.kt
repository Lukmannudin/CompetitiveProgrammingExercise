package leetcode

import java.util.*

object RegularExpressionMatching {

    @JvmStatic
    fun main(args: Array<String>) {

//        println(isMatch("aa", "a")) //false
//        println(isMatch("mississippi", "mis*is*ip*.")) //true
//        println(isMatch("ab", ".*c")) //false
//        println(isMatch("aab", "c*a*b")) //true
//        println(isMatch("aaa", "aaaa")) // false
//        println(isMatch("aaa", "ab*a*c*a")) // true
//        println(isMatch("aaa", "a*a")) //true
        println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")) //true
//        println(isMatch("asdfas", ".*asdf.*s")) //true
//
    }

    fun isMatch(s: String, p: String): Boolean {
        val stringStack = Stack<Char>()
        val expressionStack = Stack<Char>()
        var lastPreceeding: Char? = null

        for (char in s) {
            stringStack.push(char)
        }

        for (char in p) {
            expressionStack.push(char)
        }

        while (stringStack.isNotEmpty() || expressionStack.isNotEmpty()) {

            if (stringStack.isEmpty() && expressionStack.isNotEmpty()) {
                if (expressionStack.size == 1 && expressionStack.peek() == lastPreceeding) {
                    return true
                } else if (expressionStack.peek() != '*') {
                    return false
                }
            }

            if (stringStack.isNotEmpty() && expressionStack.isEmpty()) {
                return false
            }

            when (expressionStack.peek()) {
                '*' -> {
                    expressionStack.pop()
                    var exp = expressionStack.pop()

                    if (exp == '.') {
                        exp = if (stringStack.isEmpty()) {
                            return true
                        } else {
                            stringStack.pop()
                        }
                    }

                    while (
                        (stringStack.isNotEmpty() && exp != null) &&
                        (exp == stringStack.peek())
                    ) {
                        lastPreceeding = stringStack.pop()
                    }
                }
                stringStack.peek(), '.' -> {
                    stringStack.pop()
                    expressionStack.pop()
                }
                else -> {
                    return false
                }
            }
        }

        return expressionStack.isEmpty() && stringStack.isEmpty()
    }
}