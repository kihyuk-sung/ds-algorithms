fun main() {
    val (n, b) = readln().split(" ").map { it.toLong() }

    val matrix = buildMatrix(n)

    println((matrix power b).toStringResult())

}

fun buildMatrix(n: Long): List<List<Int>> = buildList {
    for (i in 0 until n) {
        add(readln().split(" ") .map { it.toInt() })
    }
}

infix fun List<List<Int>>.power(b: Long): List<List<Int>> {
    if (b == 1L) {
        return this.map {
            it.map { v -> v % 1000 }
        }
    }

    val halfB = b / 2
    val powerB = this power halfB
    if (b % 2L == 0L) {
        return powerB * powerB
    }

    return powerB * powerB * this
}

operator fun List<List<Int>>.times(other: List<List<Int>>): List<List<Int>> {
    val result = MutableList(this.size) {
        MutableList(other.first().size) { 0 }
    }

    for (i in this.indices) {
        for (j in other.first().indices) {
            for (k in other.indices) {
                result[i][j] = (result[i][j] + this[i][k] * other[k][j]) % 1000
            }
        }
    }

    return result
}

fun List<List<Int>>.toStringResult(): String = buildString {
    this@toStringResult.forEach {
        this.append(it.joinToString(" "))
        this.append("\n")
    }
}
