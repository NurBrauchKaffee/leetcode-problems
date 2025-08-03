package solutions.ArrayOrString

val map = mapOf(
    Pair(1, 'I'),
    Pair(5, 'V'),
    Pair(10, 'X'),
    Pair(50, 'L'),
    Pair(100, 'C'),
    Pair(500, 'D'),
    Pair(1000, 'M')
)

fun intToRoman(num: Int): String {
    var number = num
    var digit = 1
    var size = 0
    var res = ""

    while (num / digit >= 10) {
        digit *= 10
        size++
    }

    val digits = IntArray(++size)
    var j = 0

    while (digit >= 1) {
        val part = number / digit * digit
        digits[j++] = part
        number -= part
        digit /= 10
    }

    for (i in digits.indices) {
        var foo = digits[i]
        val subs = map.keys.toList().reversed()
        for (sub in subs) {
            if (foo - sub >= 0) {
                do {
                    foo -= sub
                    res = res.plus(map[sub])
                } while (foo - sub >= 0)
            }
        }
    }

    res = res.replace("VIIII", "IX")
        .replace("IIII", "IV")
        .replace("LXXXX", "XC")
        .replace("XXXX", "XL")
        .replace("DCCCC", "CM")
        .replace("CCCC", "CD")

    return res
}

private fun showcase(testcases: List<Int>) {
    for (testcase in testcases) {
        println("number: $testcase, Roman number: ${intToRoman(testcase)}")
    }
}

fun main() {
    val testcases: List<Int> = listOf(
        3749,
        58,
        1994,
        6
    )

    showcase(testcases)
}