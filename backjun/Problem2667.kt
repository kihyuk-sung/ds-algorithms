fun main() {
    val n = readln().toInt()
    val map = mutableListOf<List<Int>>()
    for(i in 0 until n) {
        map.add(
            readln().toCharArray().map { it.digitToInt() }
        )
    }

    val result = findCluster(map)
    println(result.size)
    println(result.joinToString(separator = "\n"))
}

fun findCluster(map: List<List<Int>>): List<Int> {
    val result = mutableListOf<Int>()

    val visited = mutableSetOf<Pair<Int, Int>>()

    for (r in map.indices) {
        val row = map[r]
        for (c in row.indices) {
            if (r to c !in visited && row[c] == 1) {
                result.add(travel(map, r, c, visited))
            }
        }
    }

    return result.sorted()
}

fun travel(map: List<List<Int>>, r: Int, c: Int, visited: MutableSet<Pair<Int, Int>>): Int {
    var result = 0

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(r to c)
    visited.add(r to c)
    while (queue.isNotEmpty()) {
        val (row, col) = queue.removeFirst()
        result++
        checkAndVisit(map, row, col + 1, visited, queue)
        checkAndVisit(map, row, col - 1, visited, queue)
        checkAndVisit(map, row + 1, col, visited, queue)
        checkAndVisit(map, row - 1, col, visited, queue)
    }

    return result
}

fun check(map: List<List<Int>>, r: Int, c: Int): Boolean = map.getOrNull(r)?.getOrNull(c) == 1

fun checkAndVisit(map: List<List<Int>>, r: Int, c: Int, visited: MutableSet<Pair<Int, Int>>, queue: ArrayDeque<Pair<Int, Int>>) {
    val p = r to c
    if (check(map, r, c) && p !in visited) {
        visited.add(p)
        queue.add(p)
    }
}
