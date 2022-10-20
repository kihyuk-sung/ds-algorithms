fun main() {
    val n = readln()
    val numbers = readln().split(" ").map { it.toInt() }

    val max = numbers.maxOrNull() ?: 0
    val min = numbers.minOrNull() ?: 0

    println(max * min)
}
