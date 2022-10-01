import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (_, peopleWhoKnowTruth) = readLineToNumberAndList(mutableSetOf())
    val parties = mutableListOf<Set<Int>>()

    for (i in 0 until m) {
        val (_, peopleWhoParticipate) = readLineToNumberAndList(mutableSetOf())
        parties.add(peopleWhoParticipate.toSet())
    }

    println(maxLieParty(n, parties, peopleWhoKnowTruth.toSet()))
}

fun readLineToNumberAndList(destination: MutableCollection<Int>): Pair<Int, Collection<Int>> {
    val numbers = readln().split(" ").map { it.toInt() }
    return numbers.first() to numbers.mapIndexedNotNullTo(destination) { index, value ->
        if (index == 0) null
        else value
    }
}

fun maxLieParty(n: Int, parties: List<Set<Int>>, peopleWhoKnowTruth: Set<Int>): Int {
    val parents = IntArray(n + 1) { it }

    parties.forEach { parents.unionGraph(it) }

    return parties.count {
        val graph = parents.findGraph(it.first())
        peopleWhoKnowTruth.all { p -> parents.findGraph(p) != graph }
    }
}

fun IntArray.findGraph(x: Int): Int = if (this[x] == x) {
    x
} else {
    val result = this.findGraph(this[x])
    this[x] = result
    result
}

fun IntArray.unionGraph(nodes: Set<Int>) {
    if (nodes.isEmpty()) return

    val first = nodes.first()

    nodes.forEach { this.unionGraph(first, it) }
}

fun IntArray.unionGraph(x: Int, y: Int) {
    val xParent = this.findGraph(x)
    val yParent = this.findGraph(y)

    val min = min(xParent, yParent)
    val max = max(xParent, yParent)

    this[max] = this[min]
}
