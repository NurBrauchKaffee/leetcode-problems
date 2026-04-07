package yandex_practice

fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    var res = 0

    for (i in startTime.indices) {
        if (startTime[i] > queryTime || endTime[i] < queryTime) {
            continue
        }

        res++
    }

    return res
}

fun main() {
    println(busyStudent(intArrayOf(1,2,3), intArrayOf(3,2,7), 4))
    println(busyStudent(intArrayOf(4), intArrayOf(4), 4))
}