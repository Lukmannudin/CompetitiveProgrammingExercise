package leetcode

object LongestSubstringWithoutRepeatingCharacters {

    @JvmStatic
    fun main(args: Array<String>) {
        println(lengthOfLongestSubstring("pwwkew"))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val dictionary = mutableSetOf<Char>()
        var pointerA = 0
        var pointerB = 0
        var max = 0

        if (s.length == 1 || (s.length == 2 && s[0] == s[1])){
            return 1
        }

        while (pointerB < s.length) {
            if (!dictionary.contains(s[pointerB])) {
                dictionary.add(s[pointerB])
                pointerB++
            } else {
                max = max.coerceAtLeast(dictionary.size)
                print("${s[pointerA]} removed => ")
                dictionary.remove(s[pointerA])
                pointerA++
            }
            for (i in dictionary) {
                print("$i ")
            }
            println()
        }

        return max
    }
}