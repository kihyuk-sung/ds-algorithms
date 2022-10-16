fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val cheese = mutableListOf<IntArray>()

    for (i in 0 until n) {
        cheese.add(IntArray(m).let { row ->
            readln()
                .split(" ")
                .map { it.toInt() }
                .forEachIndexed { c, v ->
                    row[c] = v
                }
            row
        })
    }

    println(
        cheese.calculateTime(n, m)
    )
}


fun List<IntArray>.calculateTime(n: Int, m: Int): Int {
    var result = 0

    val visited = List(n) { BooleanArray(m) }
    val willRemovedCheese = List(n) { BooleanArray(m) }
    while (this.findCheeseSize() != 0) {
        this.removeCheese(n, m, willRemovedCheese, visited)
        result += 1
    }

    return result
}

fun List<IntArray>.findCheeseSize(): Int {
    var result = 0
    this.forEach { row ->
        row.forEach { cheese ->
            if (cheese == 1) {
                result++
            }
        }
    }
    return result
}

fun List<IntArray>.removeCheese(n: Int, m: Int, willRemovedCheese: List<BooleanArray>, visited: List<BooleanArray>) {
    willRemovedCheese.init()

    for (r in 0 until n) {
        for (c in 0 until m) {
            if (this[r][c] == 1 && this.willRemoved1(r, c, n, m, visited)) {
                willRemovedCheese[r][c] = true
            }
        }
    }

    willRemovedCheese.forEachIndexed { r, row ->
        row.forEachIndexed { c, willRemoved ->
            if (willRemoved) {
                this[r][c] = 2
            }
        }
    }
}

fun List<IntArray>.willRemoved1(r: Int, c: Int, n: Int, m: Int, visited: List<BooleanArray>): Boolean {
    var count = 0
    visited.init()
    visited[r][c] = true
    if (isConnectedToOuter(r + 1, c, this, n, m, visited)) {
        count++
    }
    if (isConnectedToOuter(r - 1, c, this, n, m, visited)) {
        count++
    }
    if (count >= 2) {
        return true
    }
    if (isConnectedToOuter(r, c + 1, this, n, m, visited)) {
        count++
    }
    if (count >= 2) {
        return true
    }
    if (isConnectedToOuter(r, c - 1, this, n, m, visited)) {
        count++
    }
    return count >= 2
}

fun List<BooleanArray>.init() {
    this.forEach { it.fill(false) }
}

fun isConnectedToOuter(r: Int,c: Int, cheese: List<IntArray>, n: Int, m: Int, visited: List<BooleanArray>): Boolean {
    if (cheese[r][c] == 1) {
        return false
    }
    return cheese.isOuter(r, c, n, m, visited)
}

fun List<IntArray>.isOuter(r: Int, c: Int, n: Int, m: Int, visited: List<BooleanArray>): Boolean {
    if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
        this[r][c] = 2
        return true
    }

    if (this[r][c] == 2) {
        return true
    }

    return (check(r + 1, c, n, m, visited)
            || check(r - 1, c, n, m, visited)
            || check(r, c + 1, n, m, visited)
            || check(r, c - 1, n, m, visited))
        .let {
            if (it) {
                this[r][c] = 2
            }
            it
        }
}

private fun List<IntArray>.check(
    r: Int,
    c: Int,
    n: Int,
    m: Int,
    visited: List<BooleanArray>,
): Boolean {
    if (r !in 0 until n || c !in 0 until m) {
        return false
    }

    if (this[r][c] == 2) {
        return true
    }

    if (visited[r][c]) {
        return false
    }

    if (this[r][c] == 1) {
        return false
    }

    visited[r][c] = true
    return this.isOuter(r, c, n, m, visited)
}
