fun main() {
    val (n, m) = readln().split(" ").map { it.toBigInteger() }

    println(n.divideAndRemainder(m).joinToString("\n"))
}
