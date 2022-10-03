import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val tree = buildTree(n)

    println(calculateDiagonals(n, tree).maxOfOrNull { it.value } ?: 0)
}

fun buildTree(n: Int): Map<Int, List<Pair<Int, Int>>> {
    val tree = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    for (i in 0 until n - 1) {
        val (parent, child, weight) = readln().split(" ").map { it.toInt() }
        val children = tree[parent] ?: mutableListOf()
        children.add(child to weight)
        tree[parent] = children
    }
    return tree
}

fun calculateDiagonals(n: Int, tree: Map<Int, List<Pair<Int, Int>>>): Map<Int, Int> {
    val diagonals = mutableMapOf<Int, Int>()

    calculateDiagonalDFS(node = 1, tree = tree, diagonals = diagonals)

    return diagonals
}

fun calculateDiagonalDFS(node: Int, tree: Map<Int, List<Pair<Int, Int>>>, diagonals: MutableMap<Int, Int>): Int {
    val children = tree[node] ?: listOf()

    if (children.isEmpty()) {
        return 0
    }

    val weights = children.map { (child, weight) -> weight + calculateDiagonalDFS(child, tree, diagonals) }

    weights.calculateMaxDiagonal(node = node, diagonals = diagonals)

    return weights.maxOrNull() ?: 0
}

fun List<Int>.calculateMaxDiagonal(node: Int, diagonals: MutableMap<Int, Int>) {
    var first = if (this.size > 1) max(this[0], this[1]) else this.first()
    var second = if (this.size > 1) min(this[0], this[1]) else 0

    for (i in 2 until this.size) {
        if (this[i] >= first) {
            second = first
            first = this[i]
        }
    }

    diagonals[node] = first + second
}
