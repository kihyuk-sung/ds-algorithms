
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val snakesAndLadders = mutableMapOf<Int, Int>()
    for (i in 0 until n + m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        snakesAndLadders[x] = y
    }

    println(minimumSnakeAndLadders(snakesAndLadders))
}

fun minimumSnakeAndLadders(snakesAndLadders: Map<Int, Int>): Int {
    val queue = ArrayDeque<Pair<Int, Int>>()
    val checked = mutableSetOf<Int>()

    queue.add(1 to 0)
    checked.add(1)

    while(queue.isNotEmpty()) {
        val (position, diceCount) = queue.removeFirst()

        if (position == 100) {
            return diceCount
        }

        for(dice in 1..6) {
            val next = position + dice
            if (next <= 100) {
                val nextPosition = snakesAndLadders[next] ?: next
                if (nextPosition !in checked) {
                    checked.add(nextPosition)
                    queue.add(nextPosition to diceCount + 1)
                }
            }
        }
    }

    return -1
}
