fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(first(a, b, c))
    println(second(a, b, c))
    println(third(a, b, c))
    println(forth(a, b, c))
}

fun first(a: Int, b: Int, c: Int): Int = (a + b) % c
fun second(a: Int, b: Int, c: Int): Int = ((a % c) + (b % c)) % c
fun third(a: Int, b: Int, c: Int): Int = (a * b) % c
fun forth(a: Int, b: Int, c: Int): Int = ((a % c) * (b % c)) % c
