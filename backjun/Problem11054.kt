fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    println(countLongestBitonicSubsequence(n, numbers))
}

fun countLongestBitonicSubsequence(n: Int, numbers: List<Int>): Int {
    val left = left(n, numbers)
    val right = right(n, numbers)

    left.forEachIndexed { index, _ -> left[index] += right[index] }

    return left.maxOrNull()?.let { it - 1 } ?: 0
}

fun left(n: Int, numbers: List<Int>): IntArray {
    val result = IntArray(n)

    for (i in numbers.indices) {
        result[i] = 1
        for (j in 0 until i) {
            if (numbers[j] < numbers[i] && result[i] < result[j] + 1) {
                result[i] = result[j] + 1
            }
        }
    }

    return result
}

fun right(n: Int, numbers: List<Int>): IntArray {
    val result = IntArray(n)

    for (i in numbers.size - 1 downTo 0) {
        result[i] = 1
        for (j in numbers.size - 1 downTo i) {
            if (numbers[j] < numbers[i] && result[i] < result[j] + 1) {
                result[i] = result[j] + 1
            }
        }
    }

    return result
}
