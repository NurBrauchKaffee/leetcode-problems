package solutions.ArrayOrString

fun jump(nums: IntArray): Int {
    var max = -1
    var index = 0
    var jumps = 0

    while (index < nums.lastIndex) {
        if (index >= nums.lastIndex) {
            return ++jumps
        }

        for (i in index + 1..index + nums[index]) {

            if (nums[i] + i >= max + index) {
                max = nums[i]
                index = i
            }
        }
        jumps++
    }

    return jumps
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("min jumps: ${jump(testcase)}, nums: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        intArrayOf(2, 3, 1, 1, 4),
        intArrayOf(2, 3, 0, 1, 4),
    )

    showcase(testcases)
}