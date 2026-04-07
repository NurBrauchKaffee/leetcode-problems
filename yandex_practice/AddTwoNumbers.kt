package yandex_practice

import utility.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var res: Int

    if (l1 == null && l2 == null) {
        return null
    } else if (l1 == null) {
        return l2!!
    } else if (l2 == null) {
        return l1
    } else {
        res = l1.`val` + l2.`val`
    }

    if (res > 9) {
        res -= 10

        return if (l1.next == null && l2.next == null) {
            ListNode(res, ListNode(1))
        } else if (l1.next == null) {
            ListNode(res, addTwoNumbers(ListNode(1), l2.next))
        } else if (l2.next == null) {
            ListNode(res, addTwoNumbers(l1.next, ListNode(1)))
        } else {
            l1.next.`val` += 1
            ListNode(res, addTwoNumbers(l1.next, l2.next))
        }
    }

    return ListNode(res, addTwoNumbers(l1.next, l2.next))
}

private fun showcase(testcases: List<Pair<ListNode?, ListNode?>>) {
    for (testcase in testcases) {
        println("added numbers: ")
        addTwoNumbers(testcase.first, testcase.second)?.show()
//        println("numbers: ")
//        testcase.first?.show()
//        testcase.second?.show()
    }
}

fun main() {
    val testcases: List<Pair<ListNode?, ListNode?>> = listOf(
        Pair(
            ListNode(1, ListNode(8)),
            ListNode(0)
        ),
        Pair(
            ListNode(2, ListNode(4, ListNode(3))),
            ListNode(5, ListNode(6, ListNode(4)))
        ),
        Pair(
            ListNode(0),
            ListNode(0)
        ),
        Pair(
            ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9))))))),
            ListNode(9, ListNode(9, ListNode(9, ListNode(9))))
        )
    )

    showcase(testcases)
}