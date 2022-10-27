package leetcode.test

import leetcode.RegularExpressionMatching
import org.junit.Assert.assertEquals
import org.junit.Test


class RegularExpressionMatchingTest {

    @Test
    fun isMatch() {
        val expression = RegularExpressionMatching
        assertEquals(false, expression.isMatch("aa", "a"))
        assertEquals(true, expression.isMatch("mississippi", "mis*is*ip*."))
        assertEquals(false, expression.isMatch("ab", ".*c"))
        assertEquals(true, expression.isMatch("aab", "c*a*b"))
        assertEquals(false, expression.isMatch("aaa", "aaaa"))
        assertEquals(true, expression.isMatch("aaa", "ab*a*c*a"))

//        println(isMatch("aaa", "ab*a*c*a")) // true
//        println(isMatch("aaa", "a*a")) //true
//        println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")) //true
//        println(isMatch("asdfas", ".*asdf.*s")) //true
    }
}