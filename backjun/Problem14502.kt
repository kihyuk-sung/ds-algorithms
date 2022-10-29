import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val laboratory = buildLab(n, m)

    val maxWallCount = 3
    println(
        laboratory.findMaximumSafeArea(n, m, 0, 0, maxWallCount)
    )
}

private fun buildLab(n: Int, m: Int): IntArray {
    val result = IntArray(n * m)

    for (i in 0 until n) {
        readln().split(" ").forEachIndexed { j, value ->
            result[i, j, n, m] = value.toInt()
        }
    }

    return result
}

const val EMPTY = 0
const val WALL = 1
const val VIRUS = 2

private fun ijToIndex(i: Int, j: Int, n: Int, m: Int): Int = i * m + j

private operator fun IntArray.set(i: Int, j: Int, n: Int, m: Int, value: Int) {
    this[ijToIndex(i, j, n, m)] = value
}

private operator fun IntArray.get(i: Int, j: Int, n: Int, m: Int): Int = this[ijToIndex(i, j, n, m)]

fun IntArray.findMaximumSafeArea(n: Int, m: Int, startIndex: Int, wallCount: Int, maxWallCount: Int): Int {
    if (wallCount == maxWallCount) {
        return this.countSafeArea(n, m)
    }

    var result = 0
    for (i in startIndex until this.size) {
        if (this[i] == EMPTY) {
            this[i] = WALL

            result = max(result, this.findMaximumSafeArea(n, m, i + 1, wallCount + 1, maxWallCount))

            this[i] = EMPTY
        }
    }
    return result
}

private fun IntArray.countSafeArea(n: Int, m: Int): Int {
    val area = this.clone()
    val visited = mutableSetOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (area[i, j, n, m] == VIRUS && ijToIndex(i, j, n, m) !in visited) {
                area.spread(i, j, n, m, visited)
            }
        }
    }

    return area.count { it == 0 }
}

private fun IntArray.spread(i: Int, j:Int, n: Int, m: Int, visited: MutableSet<Int>) {
    visited.add(ijToIndex(i, j, n, m))
    this[i, j, n, m] = VIRUS

    this.checkIndexAndSpread(i + 1, j, n, m, visited)
    this.checkIndexAndSpread(i - 1, j, n, m, visited)
    this.checkIndexAndSpread(i, j + 1, n, m, visited)
    this.checkIndexAndSpread(i, j - 1, n, m, visited)
}

private fun IntArray.checkIndexAndSpread(i: Int, j: Int, n: Int, m: Int, visited: MutableSet<Int>) {
    if (isAvailableIndex(i, j, n, m) && this[i, j, n, m] == EMPTY && ijToIndex(i, j, n, m) !in visited) {
        this.spread(i, j, n, m, visited)
    }
}

private fun isAvailableIndex(i: Int, j: Int, n: Int, m: Int): Boolean = i in 0 until n && j in 0 until m
