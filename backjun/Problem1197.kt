import java.util.PriorityQueue

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val graph = buildGraph(e)

    println(prim(graph, v))
}

fun buildGraph(e: Int): Map<Int, List<Pair<Int, Int>>> = buildMap<Int, MutableList<Pair<Int, Int>>> {
    for (i in 0 until e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        addEdge(a, b, c)
        addEdge(b, a, c)
    }
}

fun MutableMap<Int, MutableList<Pair<Int, Int>>>.addEdge(start: Int, end: Int, value: Int) {
    val edges = this[start] ?: mutableListOf()
    edges.add(end to value)
    this[start] = edges
}

fun prim(graph: Map<Int, List<Pair<Int, Int>>>, v: Int): Int {
    val start = graph.keys.first()
    val visited = mutableSetOf<Int>()
    visited.add(start)
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    graph[start]?.let { queue.addAll(it) }

    var result = 0

    while(visited.size < v) {
        val (next, value) = queue.poll()
        if (next in visited) {
            continue
        }

        visited.add(next)
        result += value

        if (visited.size == v) {
            break
        }
        
        graph[next]?.forEach {
            val end = it.first
            if (end !in visited) {
                queue.add(it)
            }
        }

    }

    return result
}
