fun main() {
    val result = generateSequence {
        val n = readlnOrNull()?.toIntOrNull() ?: return@generateSequence null
        one(n)
    }

    println(result.joinToString("\n"))
}

fun one(n: Int): Int {
    var result = 1
    var number = 1

    while (true) {
        if (number % n == 0) {
            break
        }

        result += 1
        number = number * 10 + 1
        number %= n
    }

    return result
}
