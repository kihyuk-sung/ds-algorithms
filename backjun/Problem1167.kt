fun main() {
    val v = readln().toInt()

    val leaves = mutableSetOf<Int>()
    val graph = buildMap {
        for (i in 0 until v) {
            val numbers = readln().split(" ").map { it.toInt() }
            val u = numbers.first()

            val edges = buildList {
                for (j in 1 until numbers.size - 1 step 2) {
                    val z = numbers[j]
                    val distance = numbers[j + 1]
                    add(z to distance)
                }
            }

            if(edges.size == 1) {
                leaves.add(u)
            }

            put(u, edges)
        }
    }

    println(findTreeDiagonal(leaves, graph))
}

fun findTreeDiagonal(leaves: Set<Int>, graph: Map<Int, List<Pair<Int, Int>>>): Int {
    val (start, _) = graph.dfs(leaves.first(), 0, mutableSetOf())
    return graph.dfs(start, 0, mutableSetOf()).second
}

fun Map<Int, List<Pair<Int, Int>>>.dfs(node: Int, depth: Int, visited: MutableSet<Int>): Pair<Int, Int> {
    visited.add(node)

    return this[node]
        ?.filter { it.first !in visited }
        ?.map { (v, distance) -> this.dfs(v, depth + distance, visited) }
        ?.maxByOrNull { it.second }
        ?: (node to depth)
}
