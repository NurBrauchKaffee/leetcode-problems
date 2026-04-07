package solutions.Matrix

fun setZeroes(matrix: Array<IntArray>): Unit {
    val cols = mutableListOf<Int>()

    for (line in matrix) {
        var hasZero = false
        for (i in line.indices) {
            if (line[i] == 0) {
                hasZero = true
                cols.add(i)
            }
        }
        if (hasZero) {
            for (i in line.indices) {
                line[i] = 0
            }
        }
    }

    for (line in matrix) {
        for (i in cols) {
            line[i] = 0
        }
    }
}

private fun showcase(testcases: List<Array<IntArray>>) {
    for (testcase in testcases) {
        println("original matrix:")
        for (line in testcase) {
            println(line.contentToString())
        }
        setZeroes(testcase)
        println("changed matrix:")
        for (line in testcase) {
            println(line.contentToString())
        }
    }
}

fun main() {
    val testcases = listOf(
        arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(1,0,1),
            intArrayOf(1,1,1),
        ),
        arrayOf(
            intArrayOf(0,1,2,0),
            intArrayOf(3,4,5,2),
            intArrayOf(1,3,1,5),
        ),
    )

    showcase(testcases)
}