package yandex_practice

fun targetIndices(nums: IntArray, target: Int): List<Int> {
    val res: MutableList<Int> = mutableListOf()

    var count = 0
    var lessThan = 0

    for (num in nums) {
        if (num == target) {
            count++
        }

        if (num < target) {
            lessThan++
        }
    }

    for (i in 0 until count) {
        res.add(lessThan++)
    }

    return res
}

fun main() {
    val nums = intArrayOf(1, 2, 5, 2, 3)
    println(targetIndices(nums, 2))
    println(targetIndices(nums, 3))
    println(targetIndices(nums, 5))
}