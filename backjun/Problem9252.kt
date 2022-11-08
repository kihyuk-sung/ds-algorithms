import kotlin.math.max

fun main() {
    val a = readln()
    val b = readln()

    val table = makeLCSTable(a, b)

    println(table[a.length][b.length])

    if (table[a.length][b.length] == 0) {
        return
    }

    println(findLCS(a, b, table))
}

fun makeLCSTable(a: String, b: String): List<IntArray> {
    val table = buildList {
        for (i in 0 until a.length + 1) {
            add(IntArray(b.length + 1))
        }
    }

    for (i in 1 until a.length + 1) {
        val aChar = a[i - 1]
        for (j in 1 until b.length + 1) {
            val bChar = b[j - 1]

            if (aChar != bChar) {
                table[i][j] = max(table[i - 1][j], table[i][j - 1])
            }

            if (aChar == bChar) {
                table[i][j] = table[i - 1][j - 1] + 1
            }
        }
    }

    return table
}


fun findLCS(a: String, b: String, table: List<IntArray>): String {
    val result = mutableListOf<Char>()

    var i = a.length
    var j = b.length

    while (table[i][j] != 0) {
        val current = table[i][j]
        val left = table[i][j - 1]
        val up = table[i - 1][j]

        when(current) {
            left -> {
                j -= 1
            }
            up -> {
                i -= 1
            }
            else -> {
                result.add(a[i - 1])
                i -= 1
                j -= 1
            }
        }
    }

    return result.reversed().joinToString("")
}
