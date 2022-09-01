fun main() {
    val t = readln().toInt()

    val results = mutableListOf<String>()
    for (i in 0 until t) {
        val commands = readln()
        val n = readln().toInt()
        val numbers = makeNumbers(readln())

        results.add(executeCommands(commands, numbers))
    }

    println(results.joinToString(separator = "\n"))
}

fun makeNumbers(numbers: String): ArrayDeque<Int> =
    numbers
        .replace("[", "")
        .replace("]","")
        .split(",")
        .mapNotNullTo(ArrayDeque()) { it.toIntOrNull() }

fun executeCommands(commands: String, numbers: ArrayDeque<Int>): String = try {
    var reversed = false
    for (c in commands) {
        when (c) {
            'R' -> reversed = !reversed
            'D' -> delete(numbers, reversed)
        }
    }
    numbers.toString(reversed)
} catch (e: Exception) {
    "error"
}

fun delete(numbers: ArrayDeque<Int>, reversed: Boolean) {
    if (reversed) {
        numbers.removeLast()
        return
    }
    numbers.removeFirst()
}

fun ArrayDeque<Int>.toString(reversed: Boolean): String = this.let {
    buildString {
        append('[')

        for (i in it.indices) {
            if (i != 0) {
                append(',')
            }

            val accessIndex = if (reversed) {
                it.size - 1 - i
            } else i

            append(it[accessIndex])
        }
        append(']')
    }
}
