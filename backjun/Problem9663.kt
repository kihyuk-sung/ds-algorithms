import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    println(nQueen(n))
}

var count = 0

fun nQueen(n: Int): Int {
    count = 0
    nQueenRecursive(0, n, IntArray(n))
    return count
}

fun nQueenRecursive(r: Int, n: Int, selected: IntArray) {
    if (r == n) {
        count += 1
        return
    }

    for (c in 0 until n) {
        if (selected.canSelect(r, c)) {
            selected[r] = c
            nQueenRecursive(r + 1, n, selected)
        }
    }
}

fun IntArray.canSelect(r: Int, c: Int): Boolean {
    for (row in 0 until r) {
        val col = this[row]
        if (c == col || r - row == abs(c - col)) {
            return false
        }
    }
    return true
}
