package yandex_practice

private fun areLettersIdentical(w1: String, w2: String): Boolean {
    if (w1.length != w2.length) {
        return false
    }

    val arr1 = w1.toCharArray()
    arr1.sort()

    val arr2 = w2.toCharArray()
    arr2.sort()

    for (i in arr1.indices) {
        if (arr1[i] != arr2[i]) {
            return false
        }
    }

    return true
}

fun removeAnagrams(words: Array<String>): List<String> {
    val res: MutableList<String> = mutableListOf()
    res.add(words[0])

    for (i in 0 until words.size - 1) {
        if (!areLettersIdentical(words[i], words[i + 1])) {
            res.add(words[i + 1])
        }
    }

    return res
}

fun main() {
    println(removeAnagrams(arrayOf("abba","baba","bbaa","cd","cd")))
    println(removeAnagrams(arrayOf("a","b","c","d","e")))
}