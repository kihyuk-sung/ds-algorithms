fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val numbers = readln().split(" ").map { it.toInt() }.sorted()

    val results = mutableSetOf<List<Int>>()
    permutation(n, m, numbers, results, mutableListOf())

    println(
        results.joinToString(separator = "\n") { it.joinToString(separator = " ") }
    )
}

fun permutation(n: Int, m: Int, numbers: List<Int>, results: MutableSet<List<Int>>, sequence: MutableList<Int>) {
    if (sequence.size == m) {
        results.add(sequence.sorted().toList())
        return
    }

    for (i in 0 until n) {
        sequence.add(numbers[i])
        permutation(n, m, numbers, results, sequence)
        sequence.removeLast()
    }
}
