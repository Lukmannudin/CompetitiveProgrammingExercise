package leetcode

object LongestCommonPrefix {

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestCommonPrefix(arrayOf("a")))
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var currentLongestPrefix = ""
        var currentPointer = 0

        if (strs[0].isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        while (currentPointer < strs[0].length) {
            val currentChar = strs[0][currentPointer]
            for (str in strs) {
                if (
                    currentPointer >= str.length || (str[currentPointer] != currentChar)) {
                    return currentLongestPrefix
                }
            }
            currentLongestPrefix += currentChar
            currentPointer++
        }

        return currentLongestPrefix
    }

    fun getPrefix(str1: String, str2: String): String {
        val min = str1.length.coerceAtMost(str2.length)
        var pointer = 0
        var currentPrefix = ""
        while (pointer < min && str1[pointer] == str2[pointer]) {
            currentPrefix += str1[pointer]
            pointer++
        }
        return currentPrefix
    }
}