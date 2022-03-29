package leetcode

object RegularExpressionMatching {

    @JvmStatic
    fun main(args: Array<String>) {

//        println(isMatch("aa", "a")) //false
//        println(isMatch("mississippi", "mis*is*ip*.")) //true
//        println(isMatch("ab", ".*c")) //false
//        println(isMatch("aab", "c*a*b")) //true
//        println(isMatch("aaa", "aaaa")) // false
//        println(isMatch("aaa", "ab*a*c*a")) // true
//        println(isMatch("aaa", "a*a")) //true
        println(isMatch("ab", ".*..c*")) //true

//
    }

    fun isMatch(s: String, p: String): Boolean {
        val expressionList = mutableListOf<Char>()
        val stringList = mutableListOf<Char>()

        for (str in s) {
            stringList.add(str)
        }

        for (exp in p) {
            expressionList.add(exp)
        }

        while (expressionList.isNotEmpty() || stringList.isNotEmpty()) {
            if (stringList.isEmpty() && expressionList.last() == '*') {
                expressionList.removeAt(expressionList.lastIndex)
                val exp = expressionList.removeAt(expressionList.lastIndex)

                if (stringList.isEmpty()) {
                    continue
                }

                while (
                    (exp == stringList.last() || exp == '.')
                ) {
                    stringList.removeAt(stringList.lastIndex)
                }
            }

            if (
                (expressionList.isEmpty() && stringList.isNotEmpty()) ||
                (expressionList.isNotEmpty() && stringList.isEmpty())
            ) {
                return false
            }

            if (expressionList.last() == stringList.last() || expressionList.last() == '.') {
                expressionList.removeAt(expressionList.lastIndex)
                stringList.removeAt(stringList.lastIndex)
            } else if (expressionList.first() == stringList.first() || expressionList.first() == '.') {
                if (expressionList.size > 1 && expressionList[1] == '*') {
                    expressionList.removeAt(1)
                    val exp = expressionList.removeAt(0)
                    while (stringList.isNotEmpty() && (exp == stringList.first() || exp == '.')) {
                        stringList.removeAt(0)
                    }
                } else {
                    expressionList.removeAt(0)
                    stringList.removeAt(0)
                }
            } else if (expressionList.last() == '*') {
                expressionList.removeAt(expressionList.lastIndex)
                val exp = expressionList.removeAt(expressionList.lastIndex)

                while (
                    (stringList.isNotEmpty() && (exp == stringList.last() || exp == '.'))
                ) {
                    stringList.removeAt(stringList.lastIndex)
                }
            }  else {
                return false
            }
        }

        return true
    }
}