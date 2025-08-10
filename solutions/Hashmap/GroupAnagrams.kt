package solutions.Hashmap

fun isAnagram(s: String, t: String): Boolean {
    val map = HashMap<Char, Int>()
    var res = true

    if (s.length != t.length) {
        return false
    }

    for (i in s.indices) {
        val c1 = s[i]
        val c2 = t[i]

        if (map.containsKey(c1)) {
            map[c1] = map[c1]!! + 1
        } else {
            map[c1] = 1
        }

        if (map.containsKey(c2)) {
            map[c2] = map[c2]!! - 1
        } else {
            map[c2] = -1
        }
    }

    for (i in map.values) {
        res = res && (i == 0)
    }

    return res
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val res = mutableListOf<List<String>>()
    val used = MutableList(strs.size) { false }

    for (i in strs.indices) {
        if (used[i]) {
            continue
        }

        val group = mutableListOf<String>()
        group.add(strs[i])

        for (j in i+1..strs.lastIndex) {
            if (isAnagram(strs[i], strs[j])) {
                group.add(strs[j])
                used[j] = true
            }
        }

        res.add(group)
    }

    return res
}

private fun showcase(testcases: List<Array<String>>) {
    for (testcase in testcases) {
        println("groups: ${groupAnagrams(testcase)}, strs: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        arrayOf("eat","tea","tan","ate","nat","bat"),
        arrayOf(""),
        arrayOf("a"),
    )

    showcase(testcases)
}