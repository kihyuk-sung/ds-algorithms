import kotlin.math.max

fun main() {
    val result = mutableListOf<Int>()

    val t = readln().toInt()
    for (i in 0 until t) {
        val n = readln().toInt()
        val sticker = mutableListOf<List<Int>>()

        sticker.add(readln().split(" ").map { it.toInt() })
        sticker.add(readln().split(" ").map { it.toInt() })

        result.add(maxScoreOfSticker(sticker, n))
    }

    println(result.joinToString(separator = "\n"))
}

fun maxScoreOfSticker(sticker: List<List<Int>>, n: Int): Int {
    val table = listOf(IntArray(n + 1), IntArray(n + 1))

    table[0][0] = 0
    table[1][0] = 0
    table[0][1] = sticker[0][0]
    table[1][1] = sticker[1][0]

    for (i in 1 until n) {
        table[0][i + 1] = sticker[0][i] + max(table[1][i], table[1][i - 1])
        table[1][i + 1] = sticker[1][i] + max(table[0][i], table[0][i - 1])
    }

    return max(table[0][n], table[1][n])
}
