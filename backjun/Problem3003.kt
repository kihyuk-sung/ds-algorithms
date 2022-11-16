fun main() {
    val pieces = listOf(1, 1, 2, 2, 2, 8)
    
    val inputs = readln().split(" ").map { it.toInt() }
    
    val result = pieces.mapIndexed { i, v -> v - inputs[i] }
    
    println(result.joinToString(" "))
}
