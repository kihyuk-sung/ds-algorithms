fun main() {
    val n = readln().toInt()
    val x = readln().split(" ").map { it.toInt() }
    val xToIndex = x.toSet().sorted().mapIndexed { index, i -> i to index }.associate { it }
    val result = x.mapNotNull { xToIndex[it] }.joinToString(separator = " ")

    print(result)
}
