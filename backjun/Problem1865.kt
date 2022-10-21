import kotlin.math.min

const val YES = "YES"
const val NO = "NO"
const val MAX = 10_001

fun main() {
    val t = readln().toInt()

    val graph = IntArray(500 * 500)

    val result = mutableListOf<String>()

    for (i in 0 until t) {
        val (n, m, w) = readln().split(" ").map { it.toInt() }
        graph.init(n, m, w)

        result.add(graph.canGoPast(n))
    }

    println(result.joinToString("\n"))
}

fun IntArray.canGoPast(n: Int): String = bellmanFord(n, 0)

fun IntArray.bellmanFord(n: Int, start: Int): String {
    val distance = IntArray(n) { MAX }
    distance[start] = 0
    for (i in 0 until n) {
        for (j in 0 until n * n) {
            val r = indexToR(j, n)
            val c = indexToC(j, n)
            if (distance[r] + this[r, c, n] < distance[c]) {
                distance[c] = distance[r] + this[r, c, n]
            }
        }
    }

    for (i in 0 until n * n) {
        val r = indexToR(i, n)
        val c = indexToC(i, n)
        if (distance[r] + this[r, c, n] < distance[c]) {
            return YES
        }
    }

    return NO
}

fun IntArray.clear(n: Int) {
    this.fill(MAX)
    for (i in 0 until n) {
        this[i, i, n] = 0
    }
}

operator fun IntArray.set(r: Int, c: Int, n: Int, value: Int) = set(rcToIndex(r, c, n), value)

operator fun IntArray.get(r: Int, c: Int, n: Int): Int = get(rcToIndex(r, c, n))

fun rcToIndex(r: Int, c: Int, n: Int) = r * n + c

fun indexToR(index: Int, n: Int): Int = index / n

fun indexToC(index: Int, n: Int): Int = index % n

fun IntArray.init(n: Int, m: Int, w: Int) {
    clear(n)
    for (i in 0 until m) {
        val (s, e, t) = readln().split(" ").map { it.toInt() }
        this[s - 1, e - 1, n] = min(this[s - 1, e - 1, n], t)
        this[e - 1, s - 1, n] = min(this[e - 1, s - 1, n], t)
    }

    for (i in 0 until w) {
        val (s, e, t) = readln().split(" ").map { it.toInt() }
        this[s - 1, e - 1, n] = min(this[s - 1, e - 1, n], -t)
    }
}
