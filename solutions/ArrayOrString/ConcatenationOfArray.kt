package solutions.ArrayOrString

fun getConcatenation(nums: IntArray): IntArray {
    return IntArray(2 * nums.size) { x -> nums[x % nums.size] }
}

fun main() {
    val test = intArrayOf(5,4,3,2,1)
    println(getConcatenation(test).contentToString())
}