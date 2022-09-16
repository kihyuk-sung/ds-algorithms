fun main() {
    val n = readln().toInt()

    val graph = mutableMapOf<Int, MutableSet<Int>>()
    for (i in 0 until n - 1) {
        val (j, k) = readln().split(" ").map { it.toInt() }

        graph.addNode(j, k)
        graph.addNode(k, j)
    }

    val result = findParents(graph, 1, n)

    for (i in 2 until result.size) {
        println(result[i])
    }
}

fun MutableMap<Int, MutableSet<Int>>.addNode(j: Int, k: Int) {
    val nodes = this[j] ?: mutableSetOf()
    nodes.add(k)
    this[j] = nodes
}

fun findParents(graph: Map<Int, Set<Int>>, start: Int, N: Int): IntArray {
    val result = IntArray(N + 1)

    findParent(graph, start, mutableSetOf(), result)

    return result
}

fun findParent(graph: Map<Int, Set<Int>>, node: Int, visited: MutableSet<Int>, result: IntArray) {
    visited.add(node)
    val connectedNodes = graph[node] ?: setOf()

    for (n in connectedNodes) {
        if (n !in visited) {
            result[n] = node
            findParent(graph, n, visited, result)
        }
    }
}
