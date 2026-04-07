package solutions.ArrayOrString

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var acc = 0

    for (i in nums) {
        if (i == 1) {
            acc += 1
        } else {
            acc = 0
        }
        max = if (max > acc) max else acc
    }

    return max
}

fun main() {
    val test = intArrayOf(1,1,0,0,0,1,1,1)
    println(findMaxConsecutiveOnes(test))
}