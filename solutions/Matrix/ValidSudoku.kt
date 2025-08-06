package solutions.Matrix

// not something that I'm proud of
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val seen = HashSet<String>()

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val number = board[i][j]
            if (number != '.'){
                if (!seen.add("$number in row $i") ||
                    !seen.add("$number in column $j") ||
                    !seen.add("$number in block ${i/3}-${j/3}")) return false

            }
        }
    }

    return true
}

private fun showcase(testcases: List<Array<CharArray>>) {
    for (testcase in testcases) {
        println("is valid?: ${isValidSudoku(testcase)}, board:")
        for (line in testcase) {
            println(line.contentToString())
        }
    }
}

fun main() {
    val testcases = listOf(
        arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'),
        ),
        arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'),
        ),
    )

    showcase(testcases)
}