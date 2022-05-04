package leetcode

object `3Sum` {
    @JvmStatic
    fun main(args: Array<String>) {
//        [-1,0,1,2,-1,-4]
//        val sums = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        val sums = threeSum(intArrayOf(0,0,0,0))
        for (sum in sums) {
            print("$sum,")
        }
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        var outerPointer = 0
        var lastOuterPointer: Int? = null
        val sortedNums = nums.sortedArray()

        while (outerPointer < sortedNums.size) {
            if (isPass(sortedNums, lastOuterPointer, outerPointer)) {
                outerPointer++
                continue
            }

            lastOuterPointer = outerPointer
            var innerPointerA = outerPointer + 1
            var innerPointerB = sortedNums.size - 1

            var lastInnerPointerA: Int? = null
            var lastInnerPointerB: Int? = null
            while (innerPointerA < innerPointerB) {

                if (isPass(sortedNums, lastInnerPointerA, innerPointerA)) {
                    innerPointerA++
                    continue
                }

                if (isPass(sortedNums, lastInnerPointerB, innerPointerB)) {
                    innerPointerB--
                    continue
                }

                lastInnerPointerA = innerPointerA
                lastInnerPointerB = innerPointerB

//                println("${sortedNums[outerPointer]},${sortedNums[innerPointerA]},${sortedNums[innerPointerB]}")
                val sum = sortedNums[outerPointer] + sortedNums[innerPointerA] + sortedNums[innerPointerB]
                if (sum >= 0) {
                    if (sum == 0) {
                        results.add(listOf(sortedNums[outerPointer], sortedNums[innerPointerA], sortedNums[innerPointerB]))
                    }
                    innerPointerB--
                } else {
                    innerPointerA++
                }
            }

            outerPointer++
        }

        return results
    }

    fun isPass(nums: IntArray, lastPointer: Int?, pointer: Int): Boolean {
        return if (lastPointer == null || lastPointer == pointer) {
            false
        } else {
            val lastPointerValue = nums[lastPointer]
            val currentPointerValue = nums[pointer]
            lastPointerValue == currentPointerValue
        }
    }
}