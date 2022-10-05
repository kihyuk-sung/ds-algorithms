fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val matrix = mutableListOf<Int>()
    for (r in 0 until n) {
        matrix.addAll(readln().toCharArray().map { it.digitToInt() })
    }

    println(minimumPath(matrix, n, m))
}

fun minimumPath(matrix: List<Int>, n: Int, m: Int): Int {
    val visited = mapOf(false to mutableSetOf(), true to mutableSetOf<Int>())
    val queue = ArrayDeque<Triple<Int, Int, Boolean>>()

    queue.add(Triple(0, 1, true))
    visited[true]?.add(0)

    while(queue.isNotEmpty()) {
        val (index, path, canBreak) = queue.removeFirst()
        if (index == matrix.size - 1) {
            return path
        }
        val x = index.indexToX(n, m)
        val y = index.indexToY(n, m)

        matrix.checkAndAdd(x = x - 1, y = y, n = n, m = m, path = path, canBreak = canBreak, visited = visited, queue = queue)
        matrix.checkAndAdd(x = x + 1, y = y, n = n, m = m, path = path, canBreak = canBreak, visited = visited, queue = queue)
        matrix.checkAndAdd(x = x, y = y - 1, n = n, m = m, path = path, canBreak = canBreak, visited = visited, queue = queue)
        matrix.checkAndAdd(x = x, y = y + 1, n = n, m = m, path = path, canBreak = canBreak, visited = visited, queue = queue)

    }

    return -1
}

fun Int.indexToX(n: Int, m: Int): Int = this / m
fun Int.indexToY(n: Int, m: Int): Int = this % m

fun xyToIndex(x: Int, y: Int, n: Int, m: Int): Int = x * m + y

fun Pair<Int, Int>.isValid(n: Int, m: Int): Boolean = this.first in 0 until n && this.second in 0 until m

fun isValid(x: Int, y: Int, n: Int, m: Int): Boolean = x in 0 until n && y in 0 until m

fun List<Int>.checkAndAdd(x: Int, y: Int, n:Int, m:Int, path: Int, canBreak: Boolean, visited: Map<Boolean, MutableSet<Int>>, queue: ArrayDeque<Triple<Int, Int, Boolean>>) {
    if (!isValid(x, y, n, m)) {
        return
    }
    if (xyToIndex(x, y, n, m) in (visited[canBreak] ?: setOf())) {
        return
    }
    val i = xyToIndex(x, y, n, m)
    if (this[i] == 0) {
        visited[canBreak]?.add(i)
        queue.add(Triple(i, path + 1, canBreak))
    } else if (this[i] == 1 && canBreak) {
        visited[false]?.add(i)
        queue.add(Triple(i, path + 1, false))
    }
}
