import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val graph = mutableMapOf<Int, MutableSet<Pair<Int, Int>>>()

    for (i in 0 until m) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }

        val e = graph[u] ?: mutableSetOf()
        e.add(v to w)
        graph[u] = e
    }

    val (start, end) = readln().split(" ").map { it.toInt() }

    println(findMinimumPath(graph, n, start, end))

}

fun findMinimumPath(graph: Map<Int, Set<Pair<Int, Int>>>, n: Int, start: Int, end: Int): Int {
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val prev = IntArray(n + 1)

    val visited = mutableSetOf<Int>()
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.add(start to 0)

    dist[start] = 0

    while (queue.isNotEmpty()) {
        val (u, minimumDist) = queue.poll()
        if (u in visited) {
            continue
        }
        visited.add(u)
        if (u == end) {
            return minimumDist
        }

        for ((v, w) in graph[u] ?: setOf()) {
            val candidateMinimumDist = minimumDist + w
            if (dist[v] > candidateMinimumDist) {
                dist[v] = candidateMinimumDist
                prev[v] = u
                queue.add(v to candidateMinimumDist)
            }
        }
    }

    return dist[end]
}
