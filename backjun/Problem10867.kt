fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    
    println(
        numbers.toSet().toList().sorted().joinToString(" ")
    )
}
