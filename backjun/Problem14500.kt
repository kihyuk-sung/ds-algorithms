import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val paper = mutableListOf<List<Int>>()
    for (i in 0 until n) {
        paper.add(
            readln().split(" ").map { it.toInt() }
        )
    }

    println(solveProblem14500(paper))
}

fun solveProblem14500(paper: List<List<Int>>): Int {
    val tetrominoes = listOf(
        Tetromino(
            1, 4, listOf(
                0 to 0, 0 to 1, 0 to 2, 0 to 3,
            )
        ),
        Tetromino(
            2, 2, listOf(
                0 to 0, 0 to 1, 1 to 0, 1 to 1,
            )
        ),
        Tetromino(
            3, 2, listOf(
                0 to 0, 1 to 0, 2 to 0, 2 to 1,
            )
        ),
        Tetromino(
            3, 2, listOf(
                0 to 0, 1 to 0, 1 to 1, 2 to 1,
            )
        ),
        Tetromino(
            2, 3, listOf(
                0 to 0, 0 to 1, 0 to 2, 1 to 1,
            )
        ),
    )
    val checked = mutableSetOf<Tetromino>()
    checked.addAll(tetrominoes)
    val queue = ArrayDeque<Tetromino>()
    queue.addAll(tetrominoes)

    var result = 0

    while (queue.isNotEmpty()) {
        val tetromino = queue.removeFirst()

        result = max(result, paper.getMaxSum(tetromino))

        listOf(
            tetromino.flipRow(),
            tetromino.flipCol(),
            tetromino.rotateLeft(),
            tetromino.rotateRight(),
        )
            .filter { it !in checked }
            .forEach {
                checked.add(it)
                queue.add(it)
            }
    }

    return result
}

fun List<List<Int>>.getMaxSum(tetromino: Tetromino): Int {
    var result = 0

    for (i in 0 until this.size - tetromino.row + 1) {
        for (j in 0 until this[i].size - tetromino.col + 1) {
            result = max(result, this.getSum(i, j, tetromino))
        }
    }

    return result
}

fun List<List<Int>>.getSum(i: Int, j: Int, tetromino: Tetromino): Int =
    tetromino.pos.sumOf { this[i + it.first][j + it.second] }

data class Tetromino(
    val row: Int,
    val col: Int,
    val pos: List<Pair<Int, Int>>,
) {
    fun flipRow(): Tetromino = Tetromino(
        row = row,
        col = col,
        pos = pos.map { row - 1 - it.first to it.second }
    )

    fun flipCol(): Tetromino = Tetromino(
        row = row,
        col = col,
        pos = pos.map { it.first to col - 1 - it.second }
    )

    fun rotateRight(): Tetromino = Tetromino(
        row = col,
        col = row,
        pos = pos.map { col - 1 - it.second  to it.first }
    )

    fun rotateLeft(): Tetromino = Tetromino(
        row = col,
        col = row,
        pos = pos.map { it.second to row - 1 - it.first }
    )
}
