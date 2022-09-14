fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val numbers = readln().split(" ").map { it.toInt() }.sorted()

    combination(n, m, numbers, 0,  mutableListOf())
}

fun combination(n: Int, m: Int, numbers: List<Int>, index: Int, result: MutableList<Int>) {
    if (result.size == m) {
        println(result.joinToString(separator = " "))
        return
    }

    for (i in index until n) {

        result.add(numbers[i])
        combination(n, m, numbers, i, result)
        result.removeLast()
    }
}
