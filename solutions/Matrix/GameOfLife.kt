package solutions.Matrix

fun gameOfLife(board: Array<IntArray>): Unit {
    val m = board.size
    val n = board[0].size
    val prevBoard = Array(m) {IntArray(n)}

    for (x in 0 until m) {
        for (y in 0 until n) {
            prevBoard[x][y] = board[x][y]
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            var neighbors = 0

            for (x in i-1..i+1) {
                if (x < 0 || x >= m) {
                    continue
                }
                for (y in j-1..j+1) {
                    if (y < 0 || y >= n) {
                        continue
                    }
                    neighbors += prevBoard[x][y]
                }
            }

            neighbors -= prevBoard[i][j]

            if (prevBoard[i][j] == 1) {
                when (neighbors) {
                    2, 3 -> board[i][j] = 1
                    else -> board[i][j] = 0
                }
            } else {
                if (neighbors == 3) {
                    board[i][j] = 1
                } else {
                    board[i][j] = 0
                }
            }
        }
    }
}

private fun showcase(testcases: List<Array<IntArray>>) {
    for (testcase in testcases) {
        println("matrix:")
        for (line in testcase) {
            println(line.contentToString())
        }
        gameOfLife(testcase)
        println("next iteration:")
        for (line in testcase) {
            println(line.contentToString())
        }
    }
}

fun main() {
    val testcases = listOf(
        arrayOf(
            intArrayOf(0,1,0),
            intArrayOf(0,0,1),
            intArrayOf(1,1,1),
            intArrayOf(0,0,0),
        ),
        arrayOf(
            intArrayOf(1,1),
            intArrayOf(1,0),
        ),
    )

    showcase(testcases)
}