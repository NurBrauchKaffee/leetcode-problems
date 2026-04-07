package yandex_practice

fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
    val seen: MutableMap<Char, Int> = mutableMapOf()
    var res = "zzzzzzzzzzzzzzzz"

    for (ch in licensePlate) {
        val c = ch.lowercaseChar()
        if (c.isLetter()) {
            if (seen.contains(c)) {
                seen[c] = seen[c]!! + 1
            } else {
                seen[c] = 1
            }
        }
    }

    outerloop@ for (word in words) {
        val map = HashMap(seen)
        for (c in word) {
            if (map.contains(c)) {
                map[c] = map[c]!! - 1
            }
        }
        for (entry in map.values) {
            if (entry > 0) {
                continue@outerloop
            }
        }
        if (word.length < res.length) {
            res = word
        }
    }

    return res
}

fun main() {
    println(shortestCompletingWord("1s3 PSt", arrayOf("step","steps","stripe","stepple")))
    println(shortestCompletingWord("1s3 456", arrayOf("looks","pest","stew","show")))
}