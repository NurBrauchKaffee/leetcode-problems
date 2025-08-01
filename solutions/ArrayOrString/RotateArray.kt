package solutions.ArrayOrString

fun rotate(nums: IntArray, k: Int): Unit {
    var temp: Int
    for (j in 1..k) {
        temp = nums[nums.size - 1]
        for (i in nums.size - 1 downTo 0) {
            nums[i] = if (i == 0) temp else nums[i - 1]
        }
    }
}

private fun showcase(testcases: List<Pair<IntArray, Int>>) {
    for (testcase in testcases) {
        print("original array: ${testcase.first.contentToString()}, rotations number: ${testcase.second}, ")
        rotate(testcase.first, testcase.second)
        print("rotated array: ${testcase.first.contentToString()}\n")
    }
}

fun main() {
    val testcases = listOf(
        Pair(
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
            3
        ),
        Pair(
            intArrayOf(-1, -100, 3, 99),
            2
        ),
    )

    showcase(testcases)
}