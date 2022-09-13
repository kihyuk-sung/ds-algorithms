fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val numbers = readln().split(" ").map { it.toInt() }.sorted()

    permutation(n, m, numbers, mutableListOf(), mutableSetOf())
}

fun permutation(n: Int, m: Int, numbers: List<Int>, result: MutableList<Int>, selected: MutableSet<Int>) {
    if (result.size == m) {
        println(result.joinToString(separator = " "))
        return
    }

    for (i in 0 until n) {
        if (i in selected) {
            continue
        }
        result.add(numbers[i])
        selected.add(i)
        permutation(n, m, numbers, result, selected)
        result.removeLast()
        selected.remove(i)
    }
}
