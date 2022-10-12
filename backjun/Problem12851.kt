fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val (minTime, count) = catch(n, k)

    println(minTime)
    println(count)
}

fun catch(n: Int, k: Int): Pair<Int, Int> {
    var minTime: Int? = null
    var count = 0
    val visited = mutableSetOf<Int>()

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(n to 0)

    while(queue.isNotEmpty()) {
        val (currentPosition, time) = queue.removeFirst()
        visited.add(currentPosition)
        if (currentPosition == k && checkMinTime(minTime, time)) {
            minTime = time
            count += 1
        }

        if (minTime == null) {
            queue.checkAndAdd(currentPosition - 1, time + 1, visited)
            queue.checkAndAdd(currentPosition + 1, time + 1, visited)
            queue.checkAndAdd(currentPosition * 2, time + 1, visited)
        }
    }

    return minTime!! to count
}

fun checkMinTime(minTime: Int?, time: Int): Boolean = minTime == null || minTime == time

fun ArrayDeque<Pair<Int, Int>>.checkAndAdd(position: Int, time: Int, visited: Set<Int>) {
    if (position in 0..100_000 && position !in visited) {
        this.add(position to time)
    }
}
