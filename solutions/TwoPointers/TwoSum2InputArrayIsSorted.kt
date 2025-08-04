package solutions.TwoPointers

fun twoSum(numbers: IntArray, target: Int): IntArray {
    val res = IntArray(2)

    for (i in numbers.indices) {
        for (j in i + 1 until numbers.size) {
            val sum = numbers[i] + numbers[j]
            if (sum > target) {
                break
            }
            if (sum == target) {
                return intArrayOf(i + 1, j + 1)
            }
        }
    }

    return res
}

private fun showcase(testcases: List<Pair<IntArray, Int>>) {
    for (testcase in testcases) {
        println("indices: ${twoSum(testcase.first, testcase.second).contentToString()}, " +
                "numbers: ${testcase.first.contentToString()}, " +
                "target: ${testcase.second}")
    }
}

fun main() {
    val testcases: List<Pair<IntArray, Int>> = listOf(
        Pair(intArrayOf(2,7,11,15), 9),
        Pair(intArrayOf(2,3,4), 6),
        Pair(intArrayOf(-1,0), -1),
    )

    showcase(testcases)
}
