fun main() {
    val n = readln().toInt()
    val home = mutableListOf<List<Int>>()

    for (i in 0 until n) {
        home.add(readln().split(" ").map { it.toInt() })
    }

    println(getTotalAvailableMovePipe(n, home))
}

const val EMPTY = 0
const val WALL = 1

fun getTotalAvailableMovePipe(n: Int, home: List<List<Int>>): Int {
    val rowPipeTable = buildTable(n)
    val colPipeTable = buildTable(n)
    val diagonalPipeTable = buildTable(n)
    rowPipeTable[0][1] = 1
    rowPipeTable.fillFirstRow(home)

    for (r in 1 until n) {
        for (c in 1 until n) {
            if (home[r][c] == EMPTY) {
                rowPipeTable[r][c] = rowPipeTable[r][c - 1] + diagonalPipeTable[r][c - 1]
                colPipeTable[r][c] = colPipeTable[r - 1][c] + diagonalPipeTable[r - 1][c]
            }
            if (home[r][c] == EMPTY && home[r][c - 1] == EMPTY && home[r - 1][c] == EMPTY) {
                diagonalPipeTable[r][c] = diagonalPipeTable[r - 1][c - 1] + rowPipeTable[r - 1][c - 1] + colPipeTable[r - 1][c - 1]
            }
        }
    }

    return rowPipeTable[n - 1][n - 1] + colPipeTable[n - 1][n - 1] + diagonalPipeTable[n - 1][n - 1]
}

fun buildTable(n: Int): List<IntArray> = buildList {
    for (i in 0 until n) {
        add(IntArray(n))
    }
}

fun List<IntArray>.fillFirstRow(home: List<List<Int>>) {
    for (i in 1 until this[0].size) {
        if (home[0][i] == WALL) {
            break
        }
        this[0][i] = 1
    }
}
