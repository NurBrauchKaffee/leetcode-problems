package solutions.SlidingWindow

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var length = Integer.MAX_VALUE
    var sum = 0

    var p1 = 0
    var p2 = 0

    while (p2 < nums.size) {
        sum += nums[p2++]
        while (sum >= target) {
            length = minOf(length, p2 - p1)
            sum -= nums[p1++]
        }
    }

    return if (length == Integer.MAX_VALUE) 0 else length
}

private fun showcase(testcases: List<Pair<Int, IntArray>>) {
    for (testcase in testcases) {
        println("length: ${minSubArrayLen(testcase.first, testcase.second)}, " +
                "target: ${testcase.first}, " +
                "nums: ${testcase.second.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        Pair(15, intArrayOf(1,2,3,4,5)),
        Pair(11, intArrayOf(1,2,3,4,5)),
        Pair(7, intArrayOf(2,3,1,2,4,3)),
        Pair(4, intArrayOf(1,4,4)),
        Pair(11, intArrayOf(1,1,1,1,1,1,1,1)),
    )

    showcase(testcases)
}