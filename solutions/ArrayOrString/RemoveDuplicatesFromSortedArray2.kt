package solutions.ArrayOrString

fun removeDuplicates(nums: IntArray): Int {
    var k = 2

    for (i in 2..<nums.size) {
        if (nums[i] != nums[k-2]) {
            nums[k++] = nums[i]
        }
    }

    return k
}

fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("unique nums: ${removeDuplicates(testcase)}, nums: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        intArrayOf(0, 0, 1, 1, 1, 1, 2, 2, 2, 4),
        intArrayOf(1, 2, 2),
        intArrayOf(1, 1, 1, 1, 1, 1, 2, 3),
        intArrayOf(1, 1, 1, 2, 2, 3),
        intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3),
    )

    showcase(testcases)
}