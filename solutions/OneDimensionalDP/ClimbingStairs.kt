package solutions.OneDimensionalDP

fun climbStairs(n: Int): Int {
    var prev = 1
    var cur = 0

    for (i in 0..n) {
        val next = cur + prev
        prev = cur
        cur = next
    }

    return cur
}

private fun showcase(testcases: List<Int>) {
    for (testcase in testcases) {
        println("number of ways: ${climbStairs(testcase)}, steps: $testcase")
    }
}

fun main() {
    val testcases = listOf(
        2,
        3,
        4,
        5,
        6,
        45
    )

    showcase(testcases)
}
