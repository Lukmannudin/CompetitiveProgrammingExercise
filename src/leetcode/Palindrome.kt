package leetcode

import kotlin.jvm.JvmStatic

object Palindrome {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isPalindrome(-121))
    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0 ){
            return false
        }
        val numString = x.toString()

        var left: Int
        var right: Int

        if (numString.length % 2 == 0) {
            right = numString.length / 2
            left = right - 1
        } else {
            left = numString.length / 2
            right = left
        }

        while (left >= 0 && right < numString.length) {
            if (numString[left] == numString[right]) {
                left--
                right++
            } else {
                return false
            }
        }

        return true
    }
}