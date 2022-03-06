package leetcode

import kotlin.math.pow

object IntegerToRoman {

    @JvmStatic
    fun main(args: Array<String>) {
        println(intToRoman(1001))
    }

    fun intToRoman(num: Int): String {
        var currentValue = num
        val numString = num.toString()
        var decrement = (10.0.pow(numString.length.toDouble())).toInt()

        var result = ""

        while (currentValue > 0) {
            if (currentValue < decrement) {
                decrement /= 10
                continue
            }

            val romanAbjad = addRoman(currentValue)
            result += romanAbjad
            currentValue %= decrement
            decrement /= 10
        }

        return result
    }

    fun addRoman(currentValue: Int): String {
        var result = ""
        val romanValue = getRomanUnit(currentValue)
        val romanUnit = romanValue.first
        val romanUnitValue = romanValue.second

        val currentRemainder = currentValue % romanUnitValue
        val currentRoman = currentValue - currentRemainder

        when (val numOfRoman = currentRoman / romanUnitValue) {
            9 -> {
                val unit = getRomanUnit(currentValue * 10)
                result += romanUnit + unit.first
            }
            5 -> {
                val unit = getFiveRoman(currentValue)
                result += unit
            }
            in 6..8 -> {
                val fiveUnit = getFiveRoman(currentValue)
                val numRemainderRoman = numOfRoman - 5

                result += fiveUnit
                for (i in 0 until numRemainderRoman) {
                    result += romanUnit
                }
            }
            4 -> {
                val fiveUnit = getFiveRoman(currentValue)
                result += romanUnit + fiveUnit
            }
            else -> {
                for (i in 0 until numOfRoman) {
                    result += romanUnit
                }
            }
        }

        return result
    }

    fun getRomanUnit(currentValue: Int): Pair<String, Int> {
        return if (currentValue >= 1000) {
            Pair("M", 1000)
        } else if (currentValue in 100 until 1000) {
            Pair("C", 100)
        } else if (currentValue in 10 until 100) {
            Pair("X", 10)
        } else {
            Pair("I", 1)
        }
    }

    fun getFiveRoman(value:Int):String {
       return if (value >= 100) {
            "D"
        } else if (value in 10 until 100) {
            "L"
       } else if (value in 1 until 10) {
           "V"
       } else {
           ""
       }
    }

}