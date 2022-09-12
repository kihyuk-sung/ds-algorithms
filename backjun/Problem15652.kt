fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    permutation(n, m, 1, mutableListOf())
}

fun permutation(n: Int, m: Int, iteration: Int, result: MutableList<Int>) {
    if (result.size == m) {
        println(result.joinToString(separator = " "))
        return
    }

    for (i in iteration..n) {
        result.add(i)
        permutation(n, m, i, result)
        result.removeLast()
    }
}
