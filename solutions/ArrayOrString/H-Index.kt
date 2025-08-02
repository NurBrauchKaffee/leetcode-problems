package solutions.ArrayOrString

fun hIndex(citations: IntArray): Int {
    var res = 0

    for (h in 0..1000) {
        var count = 0

        for (i in citations.indices) {
            if (citations[i] >= h) {
                count++
            }
        }

        if (h > count) {
            res = h - 1
            break
        }
    }

    return res
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("h-index: ${hIndex(testcase)}, citations: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        intArrayOf(3, 0, 6, 1, 5),
        intArrayOf(1, 3, 1),
        intArrayOf(1),
    )

    showcase(testcases)
}