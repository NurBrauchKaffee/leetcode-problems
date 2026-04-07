package solutions.SlidingWindow

//fun allSubstrings(s: String): List<String> {
//    val res = mutableListOf<String>()
//
//    for (i in 1..s.length) {
//        var p1 = 0
//        var p2 = i
//        while (p2 <= s.length) {
//            res.add(s.substring(p1++, p2++))
//        }
//    }
//
//    return res
//}

fun isUnique(s: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    var isUnique = true

    for (c in s) {
        if (map.containsKey(c)) {
            map[c] = map[c]!!.plus(1)
        } else {
            map[c] = 1
        }
    }

    for (value in map.values) {
        isUnique = isUnique && value == 1
    }

    return isUnique
}

fun lengthOfLongestSubstring(s: String): Int {
    var length = 0
    var left = 1
    val set = mutableSetOf<Char>()

    for (i in 0..s.lastIndex) {
        if (!set.add(s[i])) {
            left = i
            break
        }
    }

    for (i in left..s.length) {
        var p1 = 0
        var p2 = i
        while (p2 <= s.length) {
            val sub = s.substring(p1++, p2++)
            if (isUnique(sub)) {
                length = maxOf(length, sub.length)
                // because there are 95 printable ascii letters
                if (length >= 95) {
                    return 95
                }
            }
        }
    }

    return length
}

private fun showcase(testcases: List<String>) {
    for (testcase in testcases) {
        println("length: ${lengthOfLongestSubstring(testcase)}, " +
                "string: $testcase")
    }
}

fun main() {
    val testcases = listOf(
        "a",
        "abcabcbb",
        "bbbbb",
        "pwwkew",
    )

    showcase(testcases)
}