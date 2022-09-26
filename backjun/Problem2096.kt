fun main() {
    val n = readln().toInt()

    val points = mutableListOf<List<Int>>()
    for (i in 0 until n) {
        points.add(readln().split(" ").map { it.toInt() })
    }

    println("${find(n, points) { it.maxOrNull() ?: 0 }} ${find(n, points) { it.minOrNull() ?: 0 }}")
}

fun find(n: Int, points: List<List<Int>>, selectValueFunction: (Iterable<Int>) -> Int): Int {
    val table = initTable(n = n)

    for (r in 0 until n) {
        table[r + 1][0] = points[r][0] + selectValueFunction(listOf(table[r][0], table[r][1]))
        table[r + 1][1] = points[r][1] + selectValueFunction(listOf(table[r][0], table[r][1], table[r][2]))
        table[r + 1][2] = points[r][2] + selectValueFunction(listOf(table[r][1], table[r][2]))
    }

    return selectValueFunction(table[n].asIterable())
}

fun initTable(n: Int): List<IntArray> {
    val result = mutableListOf<IntArray>()

    for (i in 0 until n + 1) {
        result.add(IntArray(3))
    }

    return result
}

