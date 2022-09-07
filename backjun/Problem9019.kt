fun main() {
    val t = readln().toInt()

    val results = mutableListOf<String>()
    for (i in 0 until t) {
        val (source, target) = readln().split(" ").map { it.toInt() }
        results.add(dslr(source, target))
    }

    println(results.joinToString("\n"))
}

fun dslr(source: Int, target: Int): String {
    val queue = ArrayDeque<Pair<Int, String>>()

    val checked = mutableSetOf<Int>()
    checked.add(source)
    queue.add(source to "")

    while (queue.isNotEmpty()) {
        val (value, commands) = queue.removeFirst()

        if (value == target) {
            return commands
        }

        d(value).let {
            if (it !in checked) {
                checked.add(it)
                queue.add(it to "${commands}D")
            }
        }
        s(value).let {
            if (it !in checked) {
                checked.add(it)
                queue.add(it to "${commands}S")
            }
        }
        l(value).let {
            if (it !in checked) {
                checked.add(it)
                queue.add(it to "${commands}L")
            }
        }
        r(value).let {
            if (it !in checked) {
                checked.add(it)
                queue.add(it to "${commands}R")
            }
        }
    }

    return ""
}


fun d(register: Int): Int = (register shl 1) % 10000

fun s(register: Int): Int = if (register - 1 < 0) 9999 else register - 1

fun l(register: Int): Int {
    val d1 = register / 1000
    return (register * 10 + d1) % 10000
}

fun r(register: Int): Int {
    val d4 = register % 10
    return register / 10 + d4 * 1000
}
