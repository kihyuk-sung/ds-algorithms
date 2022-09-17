fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val numbers = readln().split(" ").map { it.toInt() }.sorted()

    val results = mutableSetOf<List<Int>>()
    permutation(n, m, numbers, mutableSetOf(), results, mutableListOf())

    println(
        results.joinToString(separator = "\n") { it.joinToString(separator = " ") }
    )
}

fun permutation(n: Int, m: Int, numbers: List<Int>, selected: MutableSet<Int>, results: MutableSet<List<Int>>, sequence: MutableList<Int>) {
    if (sequence.size == m) {
        results.add(sequence.toList())
        return
    }

    for (i in 0 until n) {
        if (i in selected) {
            continue
        }
        sequence.add(numbers[i])
        selected.add(i)
        permutation(n, m, numbers, selected, results, sequence)
        sequence.removeLast()
        selected.remove(i)
    }
}
