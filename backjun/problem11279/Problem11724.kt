import java.util.Scanner

val scanner = Scanner(System.`in`)

fun main() {
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    val graph = buildGraph(m)
    val queue = ArrayDeque<Int>(n)
    val visited = mutableSetOf<Int>()
    queue.add(1)

    var result = 0

    for (u in 1..n) {
        if (u !in visited) {
            result++
            queue.add(u)
            travel(graph, visited, u)
        }
    }

    println(result)
}

fun buildGraph(m: Int): Map<Int, Set<Int>> {
    val graph = mutableMapOf<Int, MutableSet<Int>>()

    for (i in 0 until m) {
        val u = scanner.nextInt()
        val v = scanner.nextInt()
        buildEdges(u, v, graph)
        buildEdges(v, u, graph)
    }

    return graph
}

fun buildEdges(u: Int, v: Int, graph: MutableMap<Int, MutableSet<Int>>) {
    val edges = graph[u] ?: mutableSetOf()
    edges.add(v)
    graph[u] = edges
}

fun travel(graph: Map<Int, Set<Int>>, visited: MutableSet<Int>, u: Int) {
    val queue = ArrayDeque<Int>()
    val checked = mutableSetOf<Int>()
    queue.add(u)

    while (queue.isNotEmpty()) {
        val v = queue.removeFirst()
        visited.add(v)
        val edges = graph[v] ?: setOf()
        for (e in edges) {
            if (e !in checked && e !in visited) {
                checked.add(e)
                queue.add(e)
            }
        }
    }
}
