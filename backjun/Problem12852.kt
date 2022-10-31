fun main() {
    val n = readln().toInt()

    val result = make1(n)

    println(
        result.size - 1
    )

    println(
        result.joinToString(" ")
    )
}


const val NULL = -1

fun make1(n: Int): List<Int> {
    val prev = IntArray(n + 1) { NULL }

    val queue = ArrayDeque<Int>()
    queue.add(n)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (current == 1) {
            break
        }

        if (current % 3 == 0 && prev[current / 3] == NULL) {
            prev[current / 3] = current
            queue.add(current / 3)
        }

        if (current % 2 == 0 && prev[current / 2] == NULL) {
            prev[current / 2] = current
            queue.add(current / 2)
        }

        if (current - 1 >= 1 && prev[current - 1] == NULL) {
            prev[current - 1] = current
            queue.add(current - 1)
        }
    }

    return prev.trackPrev()
}

fun IntArray.trackPrev(): List<Int> {
    val result = mutableListOf<Int>()
    var current = 1

    while (current != NULL) {
        result.add(current)
        current = this[current]
    }

    return result.reversed()
}
