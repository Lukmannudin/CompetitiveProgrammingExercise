package leetcode

object ContainerWithMostWater {
    @JvmStatic
    fun main(args: Array<String>) {
        println(maxArea(intArrayOf(2,3,10,5,7,8,9)))
    }

    fun maxArea(height: IntArray): Int {
        var leftPointer = 0
        var rightPointer = height.size - 1

        var max = 0

        while (leftPointer <= rightPointer) {
            val lowestBar = height[leftPointer].coerceAtMost(height[rightPointer])
            val currentMax = lowestBar * (rightPointer - leftPointer)
            max = currentMax.coerceAtLeast(max)

           if (height[leftPointer] < height[rightPointer]) {
               leftPointer++
           } else {
               rightPointer--
           }
        }

        return max
    }
}