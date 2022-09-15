import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n + 1)

    readln().split(" ").map { it.toInt() }.forEachIndexed { index, value ->
        numbers[index + 1] = value
    }

    println(longestSubsequence(numbers))
}

fun longestSubsequence(numbers: IntArray): Int {
    if (numbers.size == 1) {
        return 0
    }

    val table = IntArray(numbers.size)

    for (i in 1 until numbers.size) {
        table[i] = ddd(numbers, table, i)
    }

    return table.maxOrNull() ?: 0
}

fun ddd(numbers: IntArray, table: IntArray, i: Int): Int {
    var result = 0
    val n = numbers[i]

    for (j in 0 until i) {
        if (numbers[j] < n) {
            result = max(result, table[j] + 1)
        }
    }

    return result
}
