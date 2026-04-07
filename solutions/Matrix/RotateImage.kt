package solutions.Matrix

// gonna return to that later
fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size
    // Transpose
    for (i in 0 until n) {
        for (j in i until n) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }
    // Reverse each row
    for (i in 0 until n) {
        matrix[i].reverse()
    }
}
