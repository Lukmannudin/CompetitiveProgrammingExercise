package leetcode

object LetterCombinationofaPhoneNumber {

    @JvmStatic
    fun main(args: Array<String>) {
        println(letterCombinations("2"))
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val dictionary = hashMapOf<Char, String>()
        dictionary['2'] = "abc"
        dictionary['3'] = "def"
        dictionary['4'] = "ghi"
        dictionary['5'] = "jkl"
        dictionary['6'] = "mno"
        dictionary['7'] = "pqrs"
        dictionary['8'] = "tuv"
        dictionary['9'] = "wxyz"

        var results = mutableListOf<String>()

        for (char in dictionary[digits[0]]!!) {
            results.add(char.toString())
        }

        for (i in 1 until digits.length) {
            val digit = digits[i]
            val dict = dictionary[digit]

            val dumpResult = mutableListOf<String>()
            for (result in results) {
                for (char in dict!!) {
                    dumpResult.add("$result$char")
                }
            }
            results = dumpResult
        }

        return results
    }


}