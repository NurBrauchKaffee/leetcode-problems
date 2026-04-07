package yandex_practice

fun reverseWords(s: String): String {
    val words = s.split(' ')
    var res = ""

    for (word in words) {
        res += word.reversed() + " "
    }

    return res.trim()
}

fun main() {
    println(reverseWords("Let's take LeetCode contest"))
}