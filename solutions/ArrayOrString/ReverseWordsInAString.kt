package solutions.ArrayOrString

fun reverseWords(s: String): String {
    var res = ""
    var word = ""

    for (c in s.toCharArray()) {
        if (c == ' ') {
            if (word != "") {
                res = word + c + res
                word = ""
            }
            continue
        }

        if (c.isLetterOrDigit()) {
            word += c
        }
    }

    res = "$word $res"

    return res.trim()
}

private fun showcase(testcases: List<String>) {
    for (testcase in testcases) {
        println("reversed words: ${reverseWords(testcase)}, words: $testcase")
    }
}

fun main() {
    val testcases: List<String> = listOf(
        "the sky is blue",
        "  hello world  ",
        "a good   example",
    )

    showcase(testcases)
}