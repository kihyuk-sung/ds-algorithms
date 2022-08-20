fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(findFastestTime(n, k))
}

fun findFastestTime(n: Int, k: Int): Int {
    val visited = mutableSetOf<Int>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(n to 0)
    while (queue.isNotEmpty()) {
        val (nPosition, depth) = queue.removeFirst()
        if (nPosition == k) {
            return depth
        }
        visited.add(nPosition)
        checkAndAddQueue(queue, visited, nPosition - 1, depth + 1)
        checkAndAddQueue(queue, visited, nPosition + 1, depth + 1)
        checkAndAddQueue(queue, visited, nPosition * 2, depth + 1)
    }

    return 0
}

fun checkAndAddQueue(queue: ArrayDeque<Pair<Int, Int>>, visited: MutableSet<Int>, n: Int, depth: Int) {
    if (n in 0..100_000 && n !in visited) {
        visited.add(n)
        queue.add(n to depth)
    }
}
