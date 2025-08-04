package solutions.TwoPointers

fun maxArea(height: IntArray): Int {
    return 0
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("max area: ${maxArea(testcase)}, height: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases: List<IntArray> = listOf(
        intArrayOf(1,8,6,2,5,4,8,3,7),
        intArrayOf(1,1),
    )

    showcase(testcases)
}