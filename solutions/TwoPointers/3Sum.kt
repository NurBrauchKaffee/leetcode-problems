package solutions.TwoPointers

fun threeSum(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0 until nums.lastIndex) {
        var j = i + 1
        var k = nums.lastIndex

        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum < 0) {
                j++
            } else if (sum > 0) {
                k--
            } else {
                val list = listOf(nums[i], nums[j], nums[k])
                if (!res.contains(list)) {
                    res.add(list)
                }
                j++
            }
        }
    }

    return res
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("sums: ${threeSum(testcase)}, nums: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases: List<IntArray> = listOf(
        intArrayOf(2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10),
        intArrayOf(-1,0,1,2,-1,-4),
        intArrayOf(0,1,1),
        intArrayOf(0,0,0),
    )

    showcase(testcases)
}