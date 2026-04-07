package yandex_practice

import kotlin.math.max
import kotlin.math.min

fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    var p1 = 0
    var p2 = 0

    var res: Array<IntArray> = arrayOf()

    while (p1 < firstList.size && p2 < secondList.size) {
        val fStart = firstList[p1][0]
        val fEnd = firstList[p1][1]

        val sStart = secondList[p2][0]
        val sEnd = secondList[p2][1]

        if (fStart <= sEnd && sStart <= fEnd) {
            res += intArrayOf(max(fStart, sStart), min(sEnd, fEnd))
        }

        if (fEnd <= sEnd) {
            p1++
        } else {
            p2++
        }
    }

    return res
}

private fun showcase(testcases: List<Pair<Array<IntArray>, Array<IntArray>>>) {
    for (testcase in testcases) {
        println("intersection: ${intervalIntersection(testcase.first, testcase.second).contentToString()}")
        print("arrays: [")

        for (arr in testcase.first) {
            print(" ${arr.contentToString()},")
        }

        print("], [")

        for (arr in testcase.second) {
            print(" ${arr.contentToString()},")
        }
        println("]")
        println("---")
    }
}

fun main() {
    val testcases: List<Pair<Array<IntArray>, Array<IntArray>>> = listOf(
        Pair(
            arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25)),
            arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))
        ),
        Pair(
            arrayOf(intArrayOf(1, 3), intArrayOf(5, 9)),
            arrayOf()
        )
    )

    showcase(testcases)
}