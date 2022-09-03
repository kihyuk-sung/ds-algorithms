fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val h = 1
    val tomatoBox = ByteArray(m * n * h)
    for (k in 0 until h) {
        for (j in 0 until n) {
            readln().split(" ").map { it.toByte() }.forEachIndexed { i, tomato ->
                tomatoBox[i, j, k, m, n, h] = tomato
            }
        }
    }

    println(calculateAllTomatoGrows(tomatoBox, m = m, n = n, h = h))
}

operator fun ByteArray.get(i: Int, j: Int, k: Int, m: Int, n: Int, h: Int): Byte
        = this[ijkToIndex(i,j,k,m,n,h)]

operator fun ByteArray.set(i: Int, j: Int, k: Int, m: Int, n: Int, h: Int, value: Byte) {
    this[ijkToIndex(i,j,k,m,n,h)] = value
}

fun iFromIndex(index: Int, m: Int, n: Int, h: Int): Int = index % m
fun jFromIndex(index: Int, m: Int, n: Int, h: Int): Int = (index / m) % n
fun kFromIndex(index: Int, m: Int, n: Int, h: Int): Int = index / (m * n)
fun ijkToIndex(i: Int, j: Int, k: Int, m: Int, n: Int, h: Int) = m * n * k + m * j + i

const val GROWN: Byte = 1
const val NOT_GROWN: Byte = 0
const val EMPTY: Byte = -1

fun calculateAllTomatoGrows(tomatoes: ByteArray, m: Int, n: Int, h: Int): Int {
    val checked = mutableSetOf<Int>()
    var result = 0
    if (tomatoes.isAllGrown()) {
        return 0
    }
    var queue = ArrayDeque<Int>(tomatoes.size)
    var nextQueue = ArrayDeque<Int>(tomatoes.size)
    tomatoes.forEachIndexed { index, state -> if (state == GROWN) queue.add(index) }
    tomatoes.forEachIndexed { index, state -> if (state == GROWN || state == EMPTY) checked.add(index) }

    while(queue.isNotEmpty()) {
        if (tomatoes.isAllGrown()) {
            return result
        }

        while (queue.isNotEmpty()) {
            val t = queue.removeFirst()
            checkAndAdd(up(t, m, n, h), tomatoes, checked, nextQueue)
            checkAndAdd(down(t, m, n, h), tomatoes, checked, nextQueue)
            checkAndAdd(right(t, m, n, h), tomatoes, checked, nextQueue)
            checkAndAdd(left(t, m, n, h), tomatoes, checked, nextQueue)
            checkAndAdd(front(t, m, n, h), tomatoes, checked, nextQueue)
            checkAndAdd(rear(t, m, n, h), tomatoes, checked, nextQueue)
        }

        val tmp = queue
        queue = nextQueue
        nextQueue = tmp
        result++
    }

    return -1
}

fun checkAndAdd(index: Int?, tomatoes: ByteArray, checked: MutableSet<Int>, queue: ArrayDeque<Int>) {
    if (index != null && index !in checked && tomatoes[index] == NOT_GROWN) {
        checked.add(index)
        queue.add(index)
        tomatoes[index] = GROWN
    }
}

fun ByteArray.isAllGrown() = this.all { it == GROWN || it == EMPTY }
fun up(index: Int, m: Int, n: Int, h: Int): Int? {
    val i = iFromIndex(index, m, n, h)
    val j = jFromIndex(index, m, n, h)
    val k = kFromIndex(index, m, n, h)

    if (k + 1 < h) {
        return ijkToIndex(i, j, k + 1, m, n, h)
    }
    return null
}
fun down(index: Int, m: Int, n: Int, h: Int): Int? {
    val i = iFromIndex(index, m, n, h)
    val j = jFromIndex(index, m, n, h)
    val k = kFromIndex(index, m, n, h)

    if (k - 1 >= 0) {
        return ijkToIndex(i, j, k - 1, m, n, h)
    }
    return null
}
fun right(index: Int, m: Int, n: Int, h: Int): Int? {
    val i = iFromIndex(index, m, n, h)
    val j = jFromIndex(index, m, n, h)
    val k = kFromIndex(index, m, n, h)

    if (i + 1 < m) {
        return ijkToIndex(i + 1, j, k, m, n, h)
    }
    return null
}
fun left(index: Int, m: Int, n: Int, h: Int): Int? {
    val i = iFromIndex(index, m, n, h)
    val j = jFromIndex(index, m, n, h)
    val k = kFromIndex(index, m, n, h)


    if (i - 1 >= 0) {
        return ijkToIndex(i - 1, j, k, m, n, h)
    }
    return null
}
fun front(index: Int, m: Int, n: Int, h: Int): Int? {
    val i = iFromIndex(index, m, n, h)
    val j = jFromIndex(index, m, n, h)
    val k = kFromIndex(index, m, n, h)

    if (j + 1 < n) {
        return ijkToIndex(i, j + 1, k, m, n, h)
    }
    return null
}
fun rear(index: Int, m: Int, n: Int, h: Int): Int? {
    val i = iFromIndex(index, m, n, h)
    val j = jFromIndex(index, m, n, h)
    val k = kFromIndex(index, m, n, h)

    if (j - 1 >= 0) {
        return ijkToIndex(i, j - 1, k, m, n, h)
    }
    return null
}
