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
//        println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")) //true
//        println(isMatch("asdfas", ".*asdf.*s")) //true
//
//        println(isMatch("aa", "a"))
//        println(isMatch("aaa", "ab*a*c*a"))
//        println(isMatch("aba", "aba*"))
        println(isMatch("aaa", "ab*a*c*a"))
    }

    fun isMatch(s: String, p: String): Boolean {
        val stackPattern = Stack<Char>()
        var stringPointer = s.length - 1
        var dumpHelper: Char? = null

        for (pattern in p) {
            stackPattern.push(pattern)
        }

        while (stackPattern.isNotEmpty()) {
            if (stringPointer < 0) {
                val pattern = stackPattern.peek()
                if (pattern == '*') {
                    stackPattern.pop()
                    stackPattern.pop()
                    continue
                } else {
                    break
                }
            }

            var expectedPattern = stackPattern.pop()
            val expectedChar = s[stringPointer]

            if (expectedPattern == '.') {
                expectedPattern = expectedChar
            }

            println("$expectedChar == $expectedPattern | $dumpHelper")
            if (expectedPattern == expectedChar) {
                stringPointer--
            } else {
                if (expectedPattern == '*') {
                    dumpHelper = stackPattern.peek()
                }

                if (dumpHelper != null) {
                    if (expectedChar == dumpHelper) {
                        stringPointer--
                    } else {
                        stackPattern.pop()
                        dumpHelper = null
                    }
                } else {
                    break
                }
            }
        }


        return stringPointer == -1 && stackPattern.isEmpty()
    }

    //    fun isMatch(s: String, p: String): Boolean {
//        var pointerString = 0
//        var pointerPattern = 0
//
//        var expectedChar: Char
//        var expectedPattern: Char
//
//
//        while (pointerPattern < p.length) {
//            if (pointerString >= s.length) {
//                pointerString--
//                pointerPattern++
//            }
//
//            expectedPattern = p[pointerPattern]
//            expectedChar = s[pointerString]
//
//            if (expectedPattern == '.') {
//                expectedPattern = expectedChar
//            }
//
//            if (expectedPattern == expectedChar) {
//                pointerPattern++
//                pointerString++
//            } else {
//                println("$expectedPattern = $expectedChar")
//
//                if (expectedPattern == '*') {
//                    if (expectedChar != p[pointerPattern - 1]) {
//                        pointerString++
//                    } else {
//                        pointerPattern++
//                    }
//                } else {
//                    pointerPattern++
//                }
//                println()
//            }
//        }
//
//        return pointerString == s.length && pointerPattern == p.length
//    }
}