import java.util.PriorityQueue


fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph: Map<Int, List<Pair<Int, Int>>> = buildGraph(m)

    val (start, end) = readln().split(" ").map { it.toInt() }
    val (minimum, list) = graph.dijkstra(n, start, end)
    println(minimum)
    println(list.size)
    println(list.joinToString(" "))
}

fun buildGraph(m: Int): Map<Int, List<Pair<Int, Int>>> = buildMap<Int, MutableList<Pair<Int, Int>>> {
    for (i in 0 until m) {
        val (s, e, t) = readln().split(" ").map { it.toInt() }
        val edges = this[s] ?: mutableListOf()
        edges.add(e to t)
        this[s] = edges
    }
}

fun Map<Int, List<Pair<Int, Int>>>.dijkstra(n: Int, start: Int, end: Int): Pair<Int, List<Int>> {
    val prev = IntArray(n + 1)
    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.second })
    val visited = mutableSetOf<Int>()
    queue.add(Triple(start, 0, 0))

    while (queue.isNotEmpty()) {
        val (node, time, p) = queue.poll()
        if (node in visited) {
            continue
        }
        visited.add(node)
        prev[node] = p

        if (node == end) {
            return time to prev.buildResultList(start, end)
        }

        for ((next, t) in this[node] ?: listOf()) {
            queue.add(Triple(next, t + time, node))
        }
    }

    return -1 to listOf()
}

fun IntArray.buildResultList(start: Int, end: Int): List<Int> {
    val result = mutableListOf<Int>()

    result.add(end)
    var current = end
    while (true) {
        val next = this[current]
        result.add(next)
        if (next == start) {
            break
        }

        current = next
    }

    return result.reversed()
}
