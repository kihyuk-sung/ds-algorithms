import java.text.DecimalFormat
import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val x = LongArray(n + 1)
    val y = LongArray(n + 1)

    for (i in 0 until n) {
        val (xx, yy) = readln().split(" ").map { it.toLong() }
        x[i] = xx
        y[i] = yy
    }

    x[n] = x[0]
    y[n] = y[0]

    println(DecimalFormat("#.0").format(calculateArea(n, x, y)))
}

fun calculateArea(n: Int, x: LongArray, y: LongArray): Double {
    var result = 0L

    for (i in 0 until n) {
        result += x[i + 1] * y[i]
    }

    for (i in 0 until n) {
        result -= x[i] * y[i + 1]
    }

    return abs(result) / 2.0
}
