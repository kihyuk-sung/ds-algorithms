fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val (m, n, x, y) = readln().split(" ").map { it.toInt() }
        println(cainCalendar(m, n, x, y))
    }

}

fun cainCalendar(m: Int, n: Int, x: Int, y: Int): Int {
    if (x > m || y > n) return -1
    if (x == y) return x

    val diff = n - m
    if (diff == 0) return -1

    var result = y
    val max = lcd(m, n)
    while(result <= max) {
        if (result % m == x || result % m == 0 && x == m) {
            return result
        }

        result += n
    }

    return -1
}

fun gcd(m: Int, n: Int): Int = if(n == 0) m else gcd(n, m % n)
fun lcd(m: Int, n: Int): Int = m * n / if (m > n) gcd(m, n) else gcd(n, m)
