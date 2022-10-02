import java.util.PriorityQueue

fun main() {
    val (n, e) = readln().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    for (i in 0 until e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph.add(a, b, c)
        graph.add(b, a, c)
    }
    val (v1, v2) = readln().split(" ").map { it.toInt() }

    println(graph.getMinimumPath(1, n, v1, v2))
}

fun MutableMap<Int, MutableList<Pair<Int, Int>>>.add(a: Int, b: Int, c: Int) {
    val edges = this[a] ?: mutableListOf()
    edges.add(b to c)
    this[a] = edges
}

fun Map<Int, List<Pair<Int, Int>>>.getMinimumPath(start: Int, end: Int): Int {
    val visited = mutableSetOf<Int>()
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.add(start to 0)

    while(queue.isNotEmpty()) {
        val (n, distance) = queue.poll()
        if (n == end) {
            return distance
        }
        if (n in visited) continue

        visited.add(n)

        for ((v, d) in this[n] ?: listOf()) {
            if (v in visited) continue
            queue.add(v to distance + d)
        }
    }

    return -1
}

fun Map<Int, List<Pair<Int, Int>>>.getMinimumPath(start: Int, end: Int, v1: Int, v2: Int): Int {
    val v1ToV2 = this.getMinimumPath(v1, v2)
    if (v1ToV2 == -1) {
        return -1
    }

    return listOf(v1 to v2, v2 to v1)
        .mapNotNull { (firstNode, secondNode) ->
            val d = this.getMinimumPath(start, firstNode)
            if (d == -1) null
            else secondNode to d
        }
        .mapNotNull { (start, distance) ->
            val d = this.getMinimumPath(start, end)
            if (d == -1) null
            else distance + d + v1ToV2
        }
        .minOrNull() ?: -1
}
