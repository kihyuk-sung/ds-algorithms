import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val solutions = readln().split(" ").map { it.toInt() }

    val (l, r) = findZeroSolution(solutions)
    println("$l $r")
}

fun findZeroSolution(solutions: List<Int>): Pair<Int, Int> {
    var left = 0
    var right = solutions.size - 1

    var leftSolution = 0
    var rightSolution = 0
    var sum = Int.MAX_VALUE
    while (left < right) {
        val leftVal = solutions[left]
        val rightVal = solutions[right]

        val sumValue = leftVal + rightVal
        if (abs(sumValue) < sum) {
            sum = abs(sumValue)
            leftSolution = leftVal
            rightSolution = rightVal
        }

        if (sumValue > 0) {
            right -= 1
        } else {
            left += 1
        }
    }

    return leftSolution to rightSolution
}
