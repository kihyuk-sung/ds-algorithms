import kotlin.math.max

fun main() {
    val s1 = readln()
    val s2 = readln()

    println(longestCommonSubsequence(s1, s2))
}

fun longestCommonSubsequence(s1: String, s2: String): Int {
    val table = buildTable(m = s1.length, n = s2.length)

    for (i in s1.indices) {
        for (j in s2.indices) {
            if (s1[i] == s2[j]) {
                table[i + 1][j + 1] = table[i][j] + 1
            } else {
                table[i + 1][j + 1] = max(table[i + 1][j], table[i][j + 1])
            }
        }
    }

    return table[s1.length][s2.length]
}

fun buildTable(m: Int, n: Int): List<IntArray> {
    val table = mutableListOf<IntArray>()

    for (i in 0 until m + 1) {
        table.add(IntArray(n + 1))
    }

    return table
}
