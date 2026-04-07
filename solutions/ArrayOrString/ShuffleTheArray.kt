package solutions.ArrayOrString

fun shuffle(nums: IntArray, n: Int): IntArray {
    val res = IntArray(2 * n)

    for (i in 0 until 2 * n step 2) {
        res[i] = nums[i/2]
        res[i+1] = nums[i/2+n]
    }

    return res
}

fun main() {
    val test = intArrayOf(1,2,3,4,5,6)
    println(shuffle(test, 3).contentToString())
}