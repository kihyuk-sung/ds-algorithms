fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    combination(n, m, 1, mutableListOf())
}

fun combination(n: Int, m: Int, iteration: Int, result: MutableList<Int>) {
    if (result.size == m) {
        println(result.joinToString(separator = " "))
        return
    }

    for (i in iteration..n) {
        result.add(i)
        combination(n, m, i + 1, result)
        result.removeLast()
    }
}
