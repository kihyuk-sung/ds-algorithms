fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = buildFriendGraph(m)

    println(getMinimumKevinBacon(n, graph))
}

fun buildFriendGraph(m: Int): Map<Int, Set<Int>> {
    val graph = mutableMapOf<Int, MutableSet<Int>>()

    for (i in 0 until m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        val uEdges = graph[u] ?: mutableSetOf()
        uEdges.add(v)
        graph[u] = uEdges
        val vEdges = graph[v] ?: mutableSetOf()
        vEdges.add(u)
        graph[v] = vEdges
    }

    return graph
}

fun getMinimumKevinBacon(n: Int, graph: Map<Int, Set<Int>>): Int {
    var result = 0
    var resultKevinBaconNumber: Int = Int.MAX_VALUE

    for (person in 1..n) {
        val kevinBaconNumber = getKevinBaconNumber(person, graph)
        if (kevinBaconNumber < resultKevinBaconNumber) {
            resultKevinBaconNumber = kevinBaconNumber
            result = person
        }
    }

    return result
}

fun getKevinBaconNumber(person: Int, graph: Map<Int, Set<Int>>): Int {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(person to 0)
    val visited = mutableSetOf<Int>()
    visited.add(person)
    var kevinBaconNumber = 0
    while (queue.isNotEmpty()) {
        val (p, depth) = queue.removeFirst()
        kevinBaconNumber += depth
        val edges = graph[p] ?: setOf()
        for(e in edges) {
            if (e !in visited) {
                queue.add(e to depth + 1)
                visited.add(e)
            }
        }
    }

    return kevinBaconNumber
}
