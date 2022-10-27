package leetcode

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val numbers = mutableListOf<String>()
        println(solution(listOf(
            "9113",
            "9876543",
            "9112345"
            ).toMutableList()))
    }

    fun solution(numbers: MutableList<String>): Boolean {
        if (numbers.isEmpty()) {
            return true
        }

        val sortedNumber = numbers.sorted()
        val leastLength = sortedNumber[0].length
        val prefix = sortedNumber[0]

        var isConsistent = true

        for (i in 1 until sortedNumber.size) {
            val number = sortedNumber[i]
            val buffer = if (number.length == leastLength && number == prefix) {
                1
            } else {
                0
            }

            val currentPrefix = sortedNumber[0].substring(0, sortedNumber[0].length - buffer)
            val expectedPrefix = prefix.substring(0, prefix.length - buffer)
            if (currentPrefix == expectedPrefix) {
                isConsistent = false
                break
            }
        }

        return isConsistent
    }
}