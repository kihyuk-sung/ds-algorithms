const val MODULAR = 1_000_000_007L

fun main() {
    val m = readln().toInt()
    var result = 0L
    for (i in 0 until m) {
        val (n, s) = readln().split(" ").map { it.toLong() }
        result = (result + mod(n, s)) % MODULAR
    }

    println(result)
}

fun inverseModular(number: Long, mod: Long): Long = pow(number, mod - 2, mod)

fun pow(number:Long, n: Long, mod: Long): Long {
    if (n == 1L) {
        return number
    }
    if (n == 0L) {
        return 0
    }

    val halfN = n / 2
    val halfPow = pow(number, halfN, mod)
    val result = (halfPow * halfPow) % mod
    if (n % 2 == 0L) {
        return result
    }

    return (result * number) % mod
}

fun mod(n: Long, s: Long, mod: Long = MODULAR): Long {
    val inverseModular = inverseModular(n, mod)
    return s * inverseModular % mod
}
