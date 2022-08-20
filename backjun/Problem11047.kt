fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val tokens = mutableListOf<Int>()

    for (i in 0 until n) {
        tokens.add(
            readln().toInt()
        )
    }

    println(findMinimumRequiredToken(tokens, k))
}

fun findMinimumRequiredToken(tokens: List<Int>, target: Int): Int {
    var result = 0
    var remain = target

    for (token in tokens.reversed()) {
        if (remain == 0) {
            break
        }

        val useTokenCount = remain / token
        result += useTokenCount
        remain -= useTokenCount * token
    }

    return result
}
