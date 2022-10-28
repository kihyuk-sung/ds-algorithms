import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").mapTo(LinkedList()) { it.toInt() }
    
    println(solveWithoutArrangeB(n, a, b))
}

fun solveBySort(n: Int, a: List<Int>, b: List<Int>): Int {
    val aSorted = a.sortedDescending()
    val bSorted = b.sorted()

    return (0 until n).sumOf { aSorted[it] * bSorted[it] }
}

fun solveWithoutArrangeB(n: Int, a: List<Int>, b: LinkedList<Int>): Int = a.sorted().let {
    it.indices.sumOf { index ->
        val maxOfB = b.maxOrNull() ?: throw AssertionError()
        b.remove(maxOfB)
        it[index] * maxOfB
    }
}
