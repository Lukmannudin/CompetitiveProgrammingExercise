package leetcode

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        println(average(2, 1))
    }

//    fun canReach(x1: Int, y1: Int, x2: Int, y2: Int): String {
//        println(average(2, 1))
//    }

    fun average(a: Int, b: Int): Double {
        return ((a + b) / 2).toDouble()
    }


//    fun canReach(x1: Int, y1: Int, x2: Int, y2: Int): String {
//        var startingCoordinate = Pair(x1, y1)
//        val endCoodinate = Pair(x2, y2)
//
//        val xEndCoordinate = endCoodinate.first
//        val yEndCoordinate = endCoodinate.second
//
//        while (startingCoordinate.first <= endCoodinate.first || startingCoordinate.second <= endCoodinate.second) {
//            val xStartCoordinate = startingCoordinate.first
//            val yStartCoordinate = startingCoordinate.second
//
//            val xRange = xEndCoordinate - xStartCoordinate
//            val yRange = yEndCoordinate - yStartCoordinate
//
//            startingCoordinate = if (xRange in 1 until yRange) {
//                Pair(xStartCoordinate + yStartCoordinate, yStartCoordinate)
//            } else if (yRange in 1 until xRange) {
//                Pair(xStartCoordinate, xStartCoordinate + yStartCoordinate)
//            } else {
//                if (xRange > 0) {
//                    Pair(xStartCoordinate + yStartCoordinate, yStartCoordinate)
//                } else if (yRange > 0) {
//                    Pair(xStartCoordinate, xStartCoordinate + yStartCoordinate)
//                } else {
//                    break
//                }
//            }
//        }
//
//
//        val isCanReach =
//            if (startingCoordinate.first == endCoodinate.first && startingCoordinate.second == endCoodinate.second) {
//                "YES"
//            } else {
//                "NO"
//            }
//
////        actual: (91, 45, expected: (62, 45)
//        println("actual: (${startingCoordinate.first}, ${startingCoordinate.second}, expected: (${endCoodinate.first}, ${endCoodinate.second})")
//        return isCanReach
//    }

}