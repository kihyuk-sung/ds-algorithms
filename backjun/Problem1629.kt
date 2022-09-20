fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }

    println(power(a, b, c))
}

fun power(a: Long, n: Long, modular: Long): Long {
    if (n == 1L) {
        return a % modular
    }

    if (n == 0L) {
        return 1L % modular
    }

    val half = n / 2L
    val halfResult = power(a, half, modular) % modular
    val result = (halfResult * halfResult) % modular
    if (n % 2L == 0L) {
        return result
    }

    return (result * a) % modular
}
