fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val cache = mutableMapOf<Int, MutableMap<Int, String>>()

    println(combination(n, m, cache))
}

fun combination(n: Int, m: Int, cache: MutableMap<Int, MutableMap<Int, String>>): String {
     if (m == n || m == 0) {
         return "1"
     }

    val cachedResult = cache[n]?.get(m)

    if (cachedResult != null) {
        return cachedResult
    }

    val result = combination(n - 1, m - 1, cache) add combination(n - 1, m, cache)
    val c = cache[n] ?: mutableMapOf()
    c[m] = result
    cache[n] = c

    return result
}

infix fun String.add(num: String): String {
    if (this.length < num.length) {
        return num add this
    }

    var carry = 0
    val result = StringBuilder()
    for (i in this.indices) {
        val a = this.getDigit(i)
        val b = num.getDigit(i)

        val digitSum = a + b + carry

        val digit =digitSum % 10
        carry = digitSum / 10

        result.append(digit)
    }
    if (carry != 0) {
        result.append(carry)
    }

    return result.reverse().toString()
}

fun String.getDigit(i: Int): Int = this.getOrNull(length - 1 - i)?.digitToInt() ?: 0
