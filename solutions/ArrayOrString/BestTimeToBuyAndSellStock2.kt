package solutions.ArrayOrString

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0

    for (i in 1 until prices.size) {
        val diff = prices[i] - prices[i - 1]
        if (diff > 0) {
            maxProfit += prices[i] - prices[i - 1]
        }
    }

    return maxProfit
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("max profit: ${maxProfit(testcase)}, prices: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        intArrayOf(7, 1, 5, 3, 6, 4),
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(7, 6, 4, 3, 1),
    )

    showcase(testcases)
}