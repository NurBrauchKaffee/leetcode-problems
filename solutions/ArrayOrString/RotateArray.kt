package solutions.ArrayOrString

fun rotate(nums: IntArray, k: Int): Unit {
    val n = nums.size

    var i = 0
    var temp = nums[i]

    for (j in 0..<n) {
        nums[(i+k)%n] = nums[i]
        i = (i+k)%n 
    }
}

fun showcase(testcases: List<Pair<IntArray, Int>>) {
    for (testcase in testcases) {
        print("original array: ${testcase.first.contentToString()}, rotations number: ${testcase.second}, ")
        rotate(testcase.first, testcase.second)
        print("rotated array: ${testcase.first.contentToString()}\n")
    }
}

fun main() {
    val testcases = listOf(
        Pair(
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
            3
        ),
        Pair(
            intArrayOf(-1, -100, 3, 99),
            2
        ),
    )

    showcase(testcases)
}