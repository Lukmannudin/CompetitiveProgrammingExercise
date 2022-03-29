package leetcode

object ValidParentheses {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isValid("]"))
    }

    fun isValid(s: String): Boolean {
        val dict = mutableListOf<Char>()

        for (char in s) {
            if (!char.isEndParentheses()){
                dict.add(char)
            } else {
                if (dict.isNotEmpty() && dict.last() == char.getOppositeParentheses()) {
                    dict.removeAt(dict.size - 1)
                } else {
                    return false
                }
            }
        }

        return dict.isEmpty()
    }

    fun Char.isEndParentheses() : Boolean {
        return this == ')' || this == '}' || this == ']'
    }

    fun Char.getOppositeParentheses(): Char {
        return  when (this) {
            ')' -> '('
            ']' -> '['
            else -> '{'
        }
    }
}