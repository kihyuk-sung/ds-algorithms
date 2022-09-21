import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val triangle = mutableListOf<Int>()

    for (i in 0 until n) {
        val numbers = readln().split(" ").map { it.toInt() }
        triangle.addAll(numbers)
    }

    println(findMaxSumOnTriangle(triangle, n))
}

fun findMaxSumOnTriangle(triangle: List<Int>, n: Int): Int {
    val table = IntArray(triangle.size)

    table[0] = triangle[0]
    var max = table[0]
    for (h in 1 until n) {
        val base = (h * (h + 1)) / 2
        for (k in 0 until h + 1) {
            val index = base + k
            table[index] = when(k) {
                0 -> triangle[index] + table[rightUp(index, h)]
                h -> triangle[index] + table[leftUp(index, h)]
                else -> triangle[index] + max(table[leftUp(index, h)], table[rightUp(index, h)])
            }
            max = max(max, table[index])
        }
    }

    return max
}

fun rightUp(index: Int, h: Int): Int = index - h
fun leftUp(index: Int, h: Int): Int = index - h - 1
