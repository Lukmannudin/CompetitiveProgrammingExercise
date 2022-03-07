package leetcode

object RomanToInteger {

    @JvmStatic
    fun main(args: Array<String>) {
        println(romanToInt("MCMXCIV"))
    }

    fun romanToInt(s: String): Int {
        var result = 0
        var pointer = 0
        while (pointer < s.length) {
            val currentNumber = getNumber(s[pointer])
            if (pointer + 1 < s.length) {
                val nextNumber = getNumber(s[pointer + 1])
                if (currentNumber < nextNumber) {
                    result += getSpecialRoman(s[pointer], s[pointer+1])
                    pointer += 2
                } else {
                    result += currentNumber
                    pointer += 1
                }
            } else {
                result += currentNumber
                pointer += 1
            }
        }
        return result
    }

    private fun getNumber(roman: Char): Int {
        return when (roman) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }

    private fun getSpecialRoman(low: Char, high: Char):Int {
        return when ("$low$high") {
            "IV" -> 4
            "IX" -> 9
            "XL" -> 40
            "XC" -> 90
            "CD" -> 400
            "CM" -> 900
            else -> 0
        }
    }
}