fun main() {
    val (r, c, t) = readln().split(" ").map { it.toInt() }

    val room = List(r) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val upperAirCleaner: Pair<Int, Int> = room.findUpperAirCleaner()
    val lowerAirCleaner = upperAirCleaner.let { (r, c) -> r + 1 to c }

    val temp = List(r) {
        IntArray(c)
    }
    for (i in 0 until t) {
        room.moveDust(temp)
        room.runUpperAirCleaner(upperAirCleaner)
        room.runLowerAirCleaner(lowerAirCleaner)
        temp.init()
    }

    println(room.sumOfDust())
}

fun List<IntArray>.findUpperAirCleaner(): Pair<Int, Int> = this.find { it == -1 }

inline fun List<IntArray>.find(predicate: (Int) -> Boolean): Pair<Int, Int> {
    for (i in this.indices) {
        val row = this[i]
        for (j in row.indices) {
            val air = row[j]
            if (predicate(air)) {
                return i to j
            }
        }
    }
    return 0 to 0
}

fun List<IntArray>.sumOfDust() = this.sumOf { it.sum() } + 2

fun List<IntArray>.moveDust(temp: List<IntArray>) {
    for (i in this.indices) {
        val row = this[i]
        for (j in row.indices) {
            val air = row[j]
            if (air > 0) {
                val moveAir = air / 5
                val u = this.calculateMoveDustAndAddToTemp(i - 1, j, moveAir, temp)
                val d = this.calculateMoveDustAndAddToTemp(i + 1, j, moveAir, temp)
                val l = this.calculateMoveDustAndAddToTemp(i, j - 1, moveAir, temp)
                val r = this.calculateMoveDustAndAddToTemp(i, j + 1, moveAir, temp)
                temp[i][j] -= u + d + l + r
            }
        }
    }

    for (i in this.indices) {
        val row = this[i]
        val tRow = temp[i]
        for (j in row.indices) {
            row[j] += tRow[j]
        }
    }
}

fun List<IntArray>.calculateMoveDustAndAddToTemp(r: Int, c: Int, moveAir: Int, temp: List<IntArray>): Int {
    val result = this.calculateMoveDust(r, c, moveAir)

    temp.add(r, c, result)

    return result
}

fun List<IntArray>.calculateMoveDust(r: Int, c: Int, moveAir: Int): Int {
    if (r !in this.indices || c !in this.first().indices || this[r][c] == -1) {
        return 0
    }

    return moveAir
}

fun List<IntArray>.add(r: Int, c: Int, moveAir: Int) {
    if (r !in this.indices || c !in this.first().indices) {
        return
    }

    this[r][c] += moveAir
}


fun List<IntArray>.init() {
    this.forEach { it.fill(0) }
}

fun List<IntArray>.runUpperAirCleaner(upperAirCleaner: Pair<Int, Int>) {
    val (r, c) = upperAirCleaner
    this[r][c] = 0
    val maxC = this.first().size - 1

    for (j in c - 1 downTo 1) {
        this[r][j] = this[r][j - 1]
    }

    for (i in r downTo 1) {
        this[i][0] = this[i - 1][0]
    }

    for (j in 0 until maxC) {
        this[0][j] = this[0][j + 1]
    }

    for (i in 0 until r) {
        this[i][maxC] = this[i + 1][maxC]
    }

    for (j in maxC downTo c + 1) {
        this[r][j] = this[r][j - 1]
    }

    if (c != maxC) {
        this[r][c + 1] = 0
    } else {
        this[r - 1][c] = 0
    }
    this[r][c] = -1
}

fun List<IntArray>.runLowerAirCleaner(LowerAirCleaner: Pair<Int, Int>) {
    val (r, c) = LowerAirCleaner
    val maxR = this.size - 1
    val maxC = this.first().size - 1
    this[r][c] = 0

    for (j in c - 1 downTo 1) {
        this[r][j] = this[r][j - 1]
    }

    for (i in r until  maxR) {
        this[i][0] = this[i + 1][0]
    }

    for (j in 0 until maxC) {
        this[maxR][j] = this[maxR][j + 1]
    }

    for (i in maxR downTo r + 1) {
        this[i][maxC] = this[i - 1][maxC]
    }

    for (j in maxC downTo c + 1) {
        this[r][j] = this[r][j - 1]
    }

    if (c != maxC) {
        this[r][c + 1] = 0
    } else {
        this[r + 1][c] = 0
    }
    this[r][c] = -1
}
