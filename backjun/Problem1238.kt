import java.util.PriorityQueue

fun main() {
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    val (n, m, x) = readln().split(" ").map { it.toInt() }
    for(i in 0 until m) {
        val (start, end, t) = readln().split(" ").map { it.toInt() }
        val edges = graph[start] ?: mutableListOf()
        edges.add(end to t)
        graph[start] = edges
    }

    println(maximumTime(graph, n, x))
}

fun maximumTime(graph: Map<Int, List<Pair<Int, Int>>>, n: Int, x: Int): Int = (1..n)
    .maxOfOrNull { dijkstra(graph, it, x) + dijkstra(graph, x, it) }
    ?: 0

fun dijkstra(graph: Map<Int, List<Pair<Int, Int>>>, start: Int, x: Int): Int {
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val visited = mutableSetOf<Int>()

    queue.add(start to 0)

    while (queue.isNotEmpty()) {
        val (position, time) = queue.poll()
        if (position in visited) continue
        if (position == x) {
            return time
        }

        visited.add(position)

        for ((next, t) in graph[position] ?: listOf()) {
            queue.add(next to time + t)
        }
    }

    return -1
}
