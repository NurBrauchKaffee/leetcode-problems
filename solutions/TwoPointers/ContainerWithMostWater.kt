package solutions.TwoPointers

import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var p1 = 0
    var p2 = height.lastIndex
    var max = -1

    while (p1 != p2) {
        val area = (p2 - p1) * min(height[p1], height[p2])
        if (area > max) {
            max = area
        }

        if (height[p1] < height[p2]) {
            p1++
        } else {
            p2--
        }
    }

    return max
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("max area: ${maxArea(testcase)}, height: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases: List<IntArray> = listOf(
        intArrayOf(1,8,6,2,5,4,8,3,7),
        intArrayOf(1,1),
    )

    showcase(testcases)
}