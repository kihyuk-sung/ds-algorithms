fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }

    println(aToB(a, b))
}

fun aToB(a: Long, b: Long): Int {
    val queue = ArrayDeque<Pair<Long, Int>>()
    val checked = mutableSetOf<Long>()

    checked.add(a)
    queue.add(a to 0)

    while (queue.isNotEmpty()) {
        val (number, count) = queue.removeFirst()

        if (number == b) {
            return count + 1
        }

        checkAndAddQueue(
            number = number * 2,
            count = count + 1,
            target = b,
            queue = queue,
            checked = checked,
        )

        checkAndAddQueue(
            number = number * 10 + 1,
            count = count + 1,
            target = b,
            queue = queue,
            checked = checked,
        )
    }

    return -1
}

fun checkAndAddQueue(number: Long, count: Int, target: Long, queue: ArrayDeque<Pair<Long, Int>>, checked: MutableSet<Long>) {
    if (number > target || number in checked) {
        return
    }

    checked.add(number)
    queue.add(number to count)
}
