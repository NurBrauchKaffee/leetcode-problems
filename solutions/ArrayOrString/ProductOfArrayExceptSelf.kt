package solutions.ArrayOrString

fun productExceptSelf(nums: IntArray): IntArray {
    val pref = IntArray(nums.size)
    val suf = IntArray(nums.size)
    val res = IntArray(nums.size)

    var prod = 1

    for (i in nums.indices) {
        prod *= nums[i]
        pref[i] = prod
    }

    prod = 1

    for (i in nums.lastIndex downTo 0) {
        prod *= nums[i]
        suf[i] = prod
    }

    res[0] = suf[1]
    res[res.lastIndex] = pref[pref.lastIndex - 1]

    for (i in 1..res.lastIndex - 1) {
        res[i] = pref[i-1] * suf[i+1]
    }

    return res
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("product array: ${productExceptSelf(testcase).contentToString()}, " +
                "original array: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(-1, 1, 0, -3, 3),
    )

    showcase(testcases)
}