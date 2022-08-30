const val INF = 0

fun main() {
    val n = readln().toInt()
    val graph = IntArray(n * n)

    for (r in 0 until n) {
        val row = readln().split(" ").map { it.toInt() }
        row.forEachIndexed { c, v -> graph[r * n + c] = v }
    }

    print(floyedWarshall(graph, n).toString(n, n))
}

fun floyedWarshall(graph: IntArray, n: Int): IntArray {
    val result = IntArray(graph.size) { graph[it] }

    for(k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (result[i, k, n] != INF && result[k, j, n] != INF && (
                            result[i, j, n] > (result[i, k, n] + result[k, j, n]) ||
                                    result[i, j, n] == INF
                            )) {
                    result[i, j, n] = result[i, k, n] + result[k, j, n]
                }
            }
        }
    }

    return result
}

operator fun IntArray.get(r: Int, c: Int, n: Int): Int = this[r * n + c]
operator fun IntArray.set(r: Int, c: Int, n: Int, v: Int) {
    this[r * n + c] = v
}

fun IntArray.toString(r: Int, c: Int): String  {
    val stringBuilder = StringBuilder()

    forEachIndexed { i, v ->
        if (i % c != 0) {
            stringBuilder.append(' ')
        }
        if (v == INF) {
            stringBuilder.append(0)
        } else {
            stringBuilder.append(1)
        }
        if (i % c == c - 1) {
            stringBuilder.append('\n')
        }
    }

    return stringBuilder.toString()
}
