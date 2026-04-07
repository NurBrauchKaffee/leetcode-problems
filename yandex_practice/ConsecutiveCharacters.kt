package yandex_practice

fun maxPower(s: String): Int {
    var max = 0
    var p = 0
    var cur = s.first()

    for (c in s.toCharArray()) {
        if (c != cur) {
            cur = c
            p = 0
        }
        p++

        max = max.coerceAtLeast(p)
    }

    return max
}

private fun showcase(testcases: List<String>) {
    for (testcase in testcases) {
        println("string: $testcase, power: ${maxPower(testcase)}")
    }
}

fun main() {
    val testcases: List<String> = listOf(
        "leetcode",
        "abbcccddddeeeeedcba"
    )

    showcase(testcases)
}