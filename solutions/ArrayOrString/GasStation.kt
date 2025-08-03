package solutions.ArrayOrString

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val diff = IntArray(gas.size)
    var sum = 0
    var index = 0
    var cur = 0

    for (i in gas.indices) {
        diff[i] = gas[i] - cost[i]
        sum += gas[i] - cost[i]
    }

    if (sum < 0) {
        return -1
    }

    for (i in diff.indices) {
        if (cur < 0) {
            cur = 0
            index = i
        }
        cur += diff[i]
    }

    return index
}

private fun showcase(testcases: List<Pair<IntArray, IntArray>>) {
    for (testcase in testcases) {
        println("starting index: ${canCompleteCircuit(testcase.first, testcase.second)}, " +
                "gas: ${testcase.first.contentToString()}, " +
                "fuel usage: ${testcase.second.contentToString()}")
    }
}

fun main() {
    val testcases: List<Pair<IntArray, IntArray>> = listOf(
        Pair(intArrayOf(1,2,3,4,5),
            intArrayOf(3,4,5,1,2)),
        Pair(intArrayOf(2,3,4),
            intArrayOf(3,4,3)),
        Pair(intArrayOf(3,1,1),
            intArrayOf(1,2,2)),
        Pair(intArrayOf(5,1,2,3,4),
            intArrayOf(4,4,1,5,1)),
        Pair(intArrayOf(5,8,2,8),
            intArrayOf(6,5,6,6)),
        Pair(intArrayOf(6,1,4,3,5),
            intArrayOf(3,8,2,4,2)),
//        Pair(intArrayOf(),
//            intArrayOf()),
    )

    showcase(testcases)
}