package leetcode

import java.lang.Math.abs

object `3SumClosest` {

    @JvmStatic
    fun main(args: Array<String>) {
//        println(threeSumClosest(intArrayOf(0, 0, 0), 1)) // 0
//        println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1)) // 2
//        println(threeSumClosest(intArrayOf(1,1,1,0), -100)) // 2
        println(threeSumClosest(intArrayOf(0,2,1,-3), 1)) // 0
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val result = mutableListOf<Int>()
        result.add(nums[0])
        result.add(nums[1])
        result.add(nums[2])

        for (i in 3 until nums.size) {
            val value = nums[i]
            val distance = kotlin.math.abs(value - target)
            val currentLowestDistance = kotlin.math.abs(result[0] - target)

            if (currentLowestDistance > distance || value == 0) {
                result.add(value)
            }
            result.sort()
            if (result.size > 3) {
                result.removeAt(result.size - 1)
            }
//            result.forEach {
//                print("$it, ")
//            }
//            println()
//            println("$currentLowestDistance > $distance")

        }
        return result.sum()
    }


    //using binary search
//    fun threeSumClosest(nums: IntArray, target: Int): Int {
//        val sortedNums = nums.sorted()
//        val result = mutableListOf<Int>()
//
//        val midPointer = findMid(nums, target)
//
//        if (midPointer == 0) {
//            return nums[0] + nums[1] + nums[2]
//        } else if (midPointer == nums.size - 1) {
//            return nums[midPointer] + nums[midPointer - 1] + nums[midPointer - 2]
//        }
//
//        var leftPointer = midPointer - 1
//        var rightPointer = midPointer + 1
//        result.add(sortedNums[midPointer])
//
//        while (result.size < 3) {
//            val leftDistance = target - sortedNums[leftPointer]
//            val rightDistance = target - sortedNums[rightPointer]
//
//            if (leftDistance <= rightDistance) {
//                result.add(sortedNums[leftPointer])
//                leftPointer--
//            } else {
//                result.add(sortedNums[rightPointer])
//                rightPointer++
//            }
//
//            if (leftPointer < 0) {
//                result.add(sortedNums[rightPointer])
//            } else if (rightPointer > sortedNums.size - 1) {
//                result.add(sortedNums[leftPointer])
//            }
//        }
//
//        return result.sum()
//    }
//
//    fun findMid(nums: IntArray, target: Int): Int {
//        var low = 0
//        var high = nums.size - 1
//        var mid = -1
//
//        while (low <= high) {
//            mid = (high + low) / 2
//            val guess = nums[mid]
//            if (guess == target) {
//                break
//            } else if (target < guess) {
//                high = mid - 1
//            } else if (target > guess) {
//                low = mid + 1
//            } else {
//                break
//            }
//        }
//
//        return mid
//    }
}