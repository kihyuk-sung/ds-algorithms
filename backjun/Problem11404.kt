import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = List(n) { r ->
        IntArray(n) { c ->
            if (r == c) {
                0
            } else {
                -1
            }
        }
    }

    for (i in 0 until m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a - 1][b - 1] = if (graph[a - 1][b - 1] == -1) c else min(graph[a - 1][b - 1], c)
    }

    val result = floydWarshal(n, graph)

    println(result.joinToString("\n") {
        it.joinToString(" ") { dist -> if (dist == -1) "0" else dist.toString() }
    })
}

fun floydWarshal(n: Int, graph: List<IntArray>): List<IntArray> {
    val result = List(n) { r ->
        IntArray(n) { c ->
            graph[r][c]
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            val iToK = result[i][k]
            if (iToK == -1) continue
            for (j in 0 until n) {
                val kToJ = result[k][j]
                if (kToJ == -1) continue

                result[i][j] = if (result[i][j] == -1) iToK + kToJ else min(iToK + kToJ, result[i][j])
            }
        }
    }

    return result
}
