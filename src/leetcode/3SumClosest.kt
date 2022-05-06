package leetcode

object `3SumClosest` {

    @JvmStatic
    fun main(args: Array<String>) {
        println(threeSumClosest(intArrayOf(0, 0, 0), 1)) // 0
        println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1)) // 2
        println(threeSumClosest(intArrayOf(1, 1, 1, 0), -100)) // 2
        println(threeSumClosest(intArrayOf(0, 2, 1, -3), 1)) // 0
        println(threeSumClosest(intArrayOf(1, 1, 1, 0), 100)) // 3
        println(threeSumClosest(intArrayOf(1, 2, 4, 8, 16, 32, 64, 128), 82)) // 82
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val sortedNums = nums.sortedArray()
        var outerPointer = 0

        val dumpSum = sortedNums[0] + sortedNums[1] + sortedNums[2]
        var closestSum = dumpSum
        var closestDistance = getDistance(dumpSum, target)

        while (outerPointer < sortedNums.size) {
            if (isSameLikeBefore(sortedNums, outerPointer, Type.Left)) {
                outerPointer++
                continue
            }

            var innerPointerA = outerPointer + 1
            var innerPointerB = sortedNums.size - 1

            while (innerPointerA < innerPointerB) {
                val currentSum = sortedNums[outerPointer] + sortedNums[innerPointerA] + sortedNums[innerPointerB]

                val currentDistance = getDistance(currentSum, target)

                if (closestDistance > currentDistance) {
                    closestSum = currentSum
                    closestDistance = currentDistance
                }

                if (currentSum >= target) {
                    innerPointerB--
                } else {
                    innerPointerA++
                }

                var isASameWithBefore = isSameLikeBefore(sortedNums, innerPointerA, Type.Left)
                var isBSameWithBefore = isSameLikeBefore(sortedNums, innerPointerB, Type.Right)

                while (isASameWithBefore || isBSameWithBefore) {
                    if (isASameWithBefore) {
                        innerPointerA++
                        isASameWithBefore = isSameLikeBefore(sortedNums, innerPointerA, Type.Left)
                    } else {
                        innerPointerB--
                        isBSameWithBefore = isSameLikeBefore(sortedNums, innerPointerB, Type.Right)
                    }
                }
            }

            outerPointer++
        }

        return closestSum
    }

    private fun isSameLikeBefore(nums: IntArray, pointer: Int, pointerType: Type): Boolean {
        val isOutOfBound = (pointer - 1) < 0 || ((pointer + 1) >= nums.size)

        if (isOutOfBound) {
            return false
        }

        return when (pointerType) {
            Type.Left -> nums[pointer] == nums[pointer - 1]
            Type.Right -> nums[pointer] == nums[pointer + 1]
        }
    }

    private fun getDistance(sum: Int, target: Int): Int {
        return kotlin.math.abs(target - sum)
    }

    enum class Type {
        Left,
        Right
    }
}