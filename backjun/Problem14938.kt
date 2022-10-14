import java.util.PriorityQueue

fun main() {
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val items = readln().split(" ").map { it.toInt() }
    for (i in 0 until r) {
        val (a, b, l) = readln().split(" ").map { it.toInt() }
        graph.addEdge(a, b, l)
        graph.addEdge(b, a, l)
    }

    println(sugangGround(graph, items, n, m))
}

fun MutableMap<Int, MutableList<Pair<Int, Int>>>.addEdge(a: Int, b: Int, l: Int) {
    val edges = this[a] ?: mutableListOf()
    edges.add(b to l)
    this[a] = edges
}

fun sugangGround(graph: Map<Int, List<Pair<Int, Int>>>, items: List<Int>, n: Int, m: Int): Int = (1..n)
    .maxOfOrNull { graph.dijkstra(items, it, m) }
    ?: 0

fun Map<Int, List<Pair<Int, Int>>>.dijkstra(items: List<Int>, start: Int, m: Int): Int {
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.second }, { it.first }))
    val visited = mutableSetOf<Int>()
    queue.add(start to 0)

    var result = 0

    while(queue.isNotEmpty()) {
        val (p, distance) = queue.poll()
        if (p in visited) continue
        visited.add(p)
        result += items[p - 1]

        for ((q, d) in this[p] ?: listOf()) {
            if (q !in visited && distance + d <= m) {
                queue.add(q to distance + d)
            }
        }
    }

    return result
}

