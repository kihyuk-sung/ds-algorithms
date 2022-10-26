fun main() {
    val n = readln().toLong()

    println(fibonacci(n, 1_000_000_007))
}

fun fibonacci(n: Long, mod: Long): Long = ((1L to 1L) to (1L to 0L)).power(n, mod).second.first

fun Pair<Pair<Long, Long>, Pair<Long, Long>>.power(n: Long, mod: Long): Pair<Pair<Long, Long>, Pair<Long, Long>> {
    if (n == 1L) return this

    val halfN = n / 2L
    val halfPower = this.power(halfN, mod)

    val multi = halfPower.multiply(halfPower, mod)
    if (n % 2L == 0L) {
        return multi
    }

    return multi.multiply(this, mod)
}

fun Pair<Pair<Long, Long>, Pair<Long, Long>>.multiply(other: Pair<Pair<Long, Long>, Pair<Long, Long>>, mod: Long): Pair<Pair<Long, Long>, Pair<Long, Long>> =
    (((this.first.first * other.first.first) % mod + (this.first.second * other.second.first) % mod) % mod to
            ((this.first.first * other.first.second) % mod + (this.first.second * other.second.second) % mod) % mod) to
    (((this.second.first * other.first.first) % mod + (this.second.second * other.second.first) % mod) % mod to
            ((this.second.first * other.first.second) % mod + (this.second.second * other.second.second) % mod) % mod)
