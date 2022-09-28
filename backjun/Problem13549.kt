import java.util.PriorityQueue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    println(catch(n, k))
}

fun catch(n: Int, k: Int): Int {
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val visited = mutableSetOf<Int>()

    queue.add(n to 0)

    while (queue.isNotEmpty()) {
        val (p, t) = queue.poll()

        if (p == k) {
            return t
        }

        if (p in visited) {
            continue
        }

        visited.add(p)

        val twice = p * 2
        if (twice !in visited && checkBoundary(twice)) {
            queue.add(twice to t)
        }

        val prev = p - 1
        if (prev !in visited && checkBoundary(prev)) {
            queue.add(prev to t + 1)
        }

        val next = p + 1
        if (next !in visited && checkBoundary(next)) {
            queue.add(next to t + 1)
        }
    }
    return -1
}
const val MAX = 100_000
fun checkBoundary(n: Int): Boolean = n in 0..MAX
