fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val nations = buildList {
        for (i in 0 until n) {
            add(readln().split(" ").map { it.toInt() })
        }
    }

    val sorted = nations.sortedWith(
        compareByDescending<List<Int>> { it[1] }
            .thenByDescending { it[2] }
            .thenByDescending { it[3] }
    )

    val rank = mutableListOf(1)

    for (i in 1 until sorted.size) {
        if (sorted[i][1] == sorted[i - 1][1] &&
            sorted[i][2] == sorted[i - 1][2] &&
            sorted[i][3] == sorted[i - 1][3]
        ) rank.add(rank[i - 1]) else {
            rank.add(i + 1)
        }
    }

    println(
        sorted.indexOfFirst { it[0] == k }.let { rank[it] }
    )
}
