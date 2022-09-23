fun main() {
    val (n, m) = readRowToInt()

    val table = makeTable(n)
    val result = mutableListOf<Int>()

    val partialSum = buildPartialSum(table, n)

    for (i in 0 until m) {
        val (x1, y1, x2, y2) = readRowToInt()

        result.add(
            getPartialSum(
                partialSum = partialSum,
                x1 = x1,
                y1 = y1,
                x2 = x2,
                y2 = y2
            )
        )

    }

    println(result.joinToString(separator = "\n"))
}

fun readRowToInt(): List<Int> = readln().split(" ").map { it.toInt() }

fun makeTable(n: Int): List<List<Int>> {
    val table = mutableListOf<List<Int>>()

    for (i in 0 until n) {
        table.add(readRowToInt())
    }

    return table
}

fun buildPartialSum(table: List<List<Int>>, n: Int): List<IntArray> {
    val partialSumMemory = buildList {
        for (i in 0 until n + 1) {
            add(IntArray(n + 1))
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            partialSumMemory[i + 1][j + 1] =
                table[i][j] + partialSumMemory[i + 1][j] + partialSumMemory[i][j + 1] - partialSumMemory[i][j]
        }
    }

    return partialSumMemory
}

fun getPartialSum(partialSum: List<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int): Int =
    partialSum[x2][y2] - partialSum[x2][y1 - 1] - partialSum[x1 - 1][y2] + partialSum[x1 - 1][y1 - 1]
