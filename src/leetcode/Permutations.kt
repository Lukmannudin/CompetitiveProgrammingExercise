package leetcode

import java.util.*


object Permutations {
    val result = mutableListOf<List<Int>>()

    @JvmStatic
    fun main(args: Array<String>) {
        val permutations = permute(intArrayOf(1, 2, 3))
        println(permutations)
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val permutation = Stack<Int>()
        val used = Array(nums.size) { false }

        if (nums.isEmpty()) return result

        backtrack(nums, permutation, used)
        return result
    }

    fun backtrack(
        nums: IntArray, permutation: Stack<Int>, used: Array<Boolean>
    ) {

        if (permutation.size == nums.size) {
            result.add(permutation.toList())
            return
        }

        for (i in nums.indices) {
            if (!used[i]) {
                used[i] = true
                permutation.push(nums[i])
                backtrack(nums, permutation, used)
                used[i] = false
                permutation.pop()
            }
        }
    }
}