fun main() {
    val n = readln().toInt()
    val cards: Set<Int> = readln().split(" ").mapTo(mutableSetOf()) { it.toInt() }

    val m = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    println(numbers.map { if (it in cards) 1 else 0 }.joinToString(" "))
}
