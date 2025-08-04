package solutions.ArrayOrString

fun convert(s: String, numRows: Int): String {
    if (numRows == 1 || numRows >= s.length) {
        return s
    }

    var res = ""
    val const = 2 * (numRows - 1)
    var index = 0

    while (index < s.length) {
        res = res.plus(s[index])
        index += const
    }

    for (i in 1 until numRows - 1) {
        var first = i
        var second = const - i

        while (first < s.length) {
            res = res.plus(s[first])
            if (second < s.length) {
                res = res.plus(s[second])
            }
            first += const
            second += const
        }
    }

    index = const / 2

    while (index < s.length) {
        res = res.plus(s[index])
        index += const
    }

    return res
}

private fun showcase(testcases: List<Pair<String, Int>>) {
    for (testcase in testcases) {
        println("zigzag: ${convert(testcase.first, testcase.second)}, " +
                "string: ${testcase.first}, " +
                "numRows: ${testcase.second}")
    }
}

fun main() {
    val testcases: List<Pair<String, Int>> = listOf(
        Pair("PAYPALISHIRING", 14),
        Pair("PAYPALISHIRING", 2),
        Pair("PAYPALISHIRING", 3),
        Pair("PAYPALISHIRING", 4),
        Pair("A", 1),
    )

    showcase(testcases)
}