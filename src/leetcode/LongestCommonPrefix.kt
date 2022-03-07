package leetcode

object LongestCommonPrefix {

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestCommonPrefix(arrayOf("")))
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        val dictionary = HashMap<Char, MutableList<String>>()

        if (strs.isEmpty() || (strs.size == 1 && strs[0] == "")) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        for (str in strs) {
            if (str.isNotEmpty()) {
                val prefix = str[0]
                if (dictionary.contains(prefix)) {
                    dictionary[prefix]?.add(str)
                } else {
                    dictionary[prefix] = mutableListOf(str)
                }
            }
        }

        val results = mutableListOf<String>()
        for (dict in dictionary) {
            val categories = dict.value
            var lastPrefix = ""
            while (categories.size - 1 > 0) {
                val currentPrefix = getPrefix(categories[0], categories[1])

                lastPrefix = if (lastPrefix.isNotEmpty()) {
                    val prefix = getPrefix(currentPrefix, lastPrefix)
                    prefix
                }  else {
                    currentPrefix
                }
                categories.removeAt(0)
            }
            if (lastPrefix.isNotEmpty()) {
                results.add(lastPrefix)
            }
            categories.removeAt(0)
        }

        var max = Pair(0, "")

        for (result in results) {
            if (result.length > max.first) {
                max = Pair(result.length, result)
            }
        }

        return max.second
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