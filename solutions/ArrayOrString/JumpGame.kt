package solutions.ArrayOrString

fun canJumpReference(nums: IntArray): Boolean {
    var goal = nums.size - 1

    for (i in nums.size - 2 downTo 0) {
        if (nums[i] + i >= goal) {
            goal = i
        }
    }

    return goal == 0
}

fun canJump(nums: IntArray): Boolean {
    var index = 0

    while (index < nums.lastIndex) {
        var max = -1

        if (nums[index] == 0) {
            return false
        }

        for (i in index + 1..index + nums[index]) {
            if (i >= nums.lastIndex) {
                return true
            }

            if (nums[i] + i >= max + index) {
                max = nums[i]
                index = i
            }
        }
    }

    return true
}

private fun showcase(testcases: List<IntArray>) {
    for (testcase in testcases) {
        println("can jump?: ${canJump(testcase)}, nums: ${testcase.contentToString()}")
    }
}

fun main() {
    val testcases = listOf(
        intArrayOf(3,2,2,0,1),
        intArrayOf(4,2,0,0,1,1,4,4,4,0,4,0),
        intArrayOf(5,9,3,2,1,0,2,3,3,1,0,0),
        intArrayOf(3, 0, 8, 2, 0, 0, 1),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0),
        intArrayOf(3, 2, 1, 0, 4),
        intArrayOf(1),
        intArrayOf(2, 5, 0, 0),
        intArrayOf(2, 3, 1, 1, 4),
    )

    showcase(testcases)
}