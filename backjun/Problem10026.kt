fun main() {
    val n = readln().toInt()
    val picture = CharArray(n * n)

    for (i in 0 until n) {
        val row = readln()
        for ((j, c) in row.withIndex()) {
            picture[i, j, n] = c
        }
    }

    println("${rgb(picture, n, mapOf(
        'R' to setOf('R'),
        'G' to setOf('G'),
        'B' to setOf('B'),
    ))} ${rgb(picture, n, mapOf(
        'R' to setOf('R', 'G'),
        'G' to setOf('R', 'G'),
        'B' to setOf('B'),
    ))}")
}

operator fun CharArray.get(i: Int, j: Int, n: Int) = this[i * n + j]
operator fun CharArray.set(i: Int, j: Int, n: Int, value: Char) {
    this[i * n + j] = value
}

fun rgb(picture: CharArray, n: Int, sameColors: Map<Char,Set<Char>>): Int {
    var result = 0

    val checked = mutableSetOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i to j !in checked) {
                travelPicture(i, j, n, picture, checked, sameColors = sameColors[picture[i, j, n]]!!)
                result++
            }
        }
    }

    return result
}

fun travelPicture(i: Int, j: Int, n: Int, picture: CharArray, checked: MutableSet<Pair<Int, Int>>, sameColors: Set<Char>) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    val start = i to j
    queue.add(start)
    checked.add(start)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        checkAndAddQueue(x, y, n, picture, checked, sameColors, queue)
    }
}

fun checkAndAddQueue(x: Int, y: Int, n: Int, picture: CharArray, checked: MutableSet<Pair<Int, Int>>, sameColors: Set<Char>, queue: ArrayDeque<Pair<Int, Int>>) {
    listOf(up(x, y, n), down(x, y, n), right(x, y, n), left(x, y, n)).mapNotNull { it }.forEach {
        val (i, j) = it
        if (it !in checked && picture[x, y, n] in sameColors && picture[i, j, n] in sameColors) {
            queue.add(it)
            checked.add(it)
        }
    }
}

fun up(r: Int, c: Int, n: Int): Pair<Int, Int>? = if (r - 1 >= 0) r - 1 to c else null
fun down(r: Int, c: Int, n: Int): Pair<Int, Int>? = if (r + 1 < n) r + 1 to c else null
fun right(r: Int, c: Int, n: Int): Pair<Int, Int>? = if (c + 1 < n) r to c + 1 else null
fun left(r: Int, c: Int, n: Int): Pair<Int, Int>? = if (c - 1 >= 0) r to c - 1 else null
