package yandex_practice

fun numUniqueEmails(emails: Array<String>): Int {
    val set: MutableSet<String> = mutableSetOf()

    for (email in emails) {
        val names = email.split("@")
        val localName = names[0].split("+")[0].replace(".", "")
        set.add(localName + "@" + names[1])
    }

    return set.size
}

private fun showcase(testcases: List<Array<String>>) {
    for (testcase in testcases) {
        println("emails: ${testcase.contentToString()}, " +
                "unique emails: ${numUniqueEmails(testcase)}")
    }
}

fun main() {
    val testcases: List<Array<String>> = listOf(
        arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"),
        arrayOf("a@leetcode.com","b@leetcode.com","c@leetcode.com")
    )

    showcase(testcases)
}