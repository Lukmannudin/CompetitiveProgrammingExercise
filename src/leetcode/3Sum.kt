package leetcode

object `3Sum` {
    @JvmStatic
    fun main(args: Array<String>) {
        val result = threeSum(intArrayOf(0,0,0))
        for (r in result) {
            println(r)
        }
    }

    @Suppress("KotlinConstantConditions")
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        // sorted because to make easier identify duplicated value
        val sortedNums = nums.sorted()

        for (i in sortedNums.indices) {
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) {
                continue
            }

            var j = i + 1
            var k = nums.size - 1

            if (i == j || j == k || k == i) {
                continue
            }

            while (j < k) {
                val currentSums = listOf(sortedNums[i], sortedNums[j], sortedNums[k])
                val resultNum = currentSums.sum()
                if (resultNum >= 0) {
                    if (resultNum == 0) {
                        result.add(currentSums)
                    }
                    k--
                    while (
                        (k + 1 < sortedNums.size && k >= 0) && sortedNums[k + 1] == sortedNums[k]
                    ) {
                        k--
                    }
                } else if (resultNum < 0) {
                    j++
                    while (
                        (j - 1 >= 0 && j < sortedNums.size) && sortedNums[j - 1] == sortedNums[j]
                    ) {
                        j++
                    }
                }
            }
        }
        return result
    }
}