import kotlin.math.abs

fun main() {
    val map = mutableListOf<List<Int>>()

    val (n, m) = readln().split(" ").map { it.toInt() }

    for (i in 0 until n) {
        map.add(readln().split(" ").map { it.toInt() })
    }

    println(minChickenDistance(n, m, map))
}

fun minChickenDistance(n: Int, m: Int, map: List<List<Int>>): Int {
    val homes = map.findPlace { it == 1 }
    val chickens = map.findPlace { it == 2 }

    return chickens.select(m).minOf { currentChickens ->
        homes.sumOf { h -> currentChickens.minOf { c -> h chickenDistance c } }
    }
}

fun List<List<Int>>.findPlace(predicate: (Int) -> Boolean): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()

    this.forEachIndexed { i, r ->
        r.forEachIndexed { j, value ->
            if (predicate(value)) {
                result.add(i to j)
            }
        }
    }

    return result
}

fun List<Pair<Int, Int>>.select(m: Int): List<List<Pair<Int, Int>>> {
    val result = mutableListOf<List<Pair<Int,Int>>>()

    this.selectRecursive(m, 0, mutableListOf(), result)

    return result
}

fun List<Pair<Int, Int>>.selectRecursive(m: Int, currentIndex: Int, currentResult: MutableList<Pair<Int, Int>>, result: MutableList<List<Pair<Int, Int>>>) {
    if (currentResult.size == m) {
        result.add(currentResult.toMutableList())
        return
    }

    for (i in currentIndex until this.size) {
        currentResult.add(this[i])
        this.selectRecursive(m, i + 1, currentResult, result)
        currentResult.removeLast()
    }
}

infix fun Pair<Int, Int>.chickenDistance(other: Pair<Int, Int>): Int = abs(this.first - other.first) + abs(this.second - other.second)
