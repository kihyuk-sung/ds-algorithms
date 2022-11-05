import kotlin.math.max

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val board = buildList{
        for (i in 0 until r) {
            add(readln())
        }
    }

    println(findMaxDepth(board, r, c))
}

fun findMaxDepth(board: List<String>, r: Int, c: Int): Int = dfs(board, r, c, 0, 0,1, mutableSetOf(board[0][0]))

fun dfs(board: List<String>, r: Int, c: Int, x: Int, y: Int, depth: Int, visited: MutableSet<Char>): Int {
    var result = depth
    checkRange(r, c, x + 1, y)
        ?.let { board.checkNotVisited(x + 1, y, visited) }
        ?.let {
            visited.add(board[x + 1][y])
            val candidate = dfs(board, r, c, x + 1, y, depth + 1, visited)
            visited.remove(board[x + 1][y])
            candidate
        }
        ?.let { result = max(result, it) }

    checkRange(r, c, x - 1, y)
        ?.let { board.checkNotVisited(x - 1, y, visited) }
        ?.let {
            visited.add(board[x - 1][y])
            val candidate = dfs(board, r, c, x - 1, y, depth + 1, visited)
            visited.remove(board[x - 1][y])
            candidate
        }
        ?.let { result = max(result, it) }

    checkRange(r, c, x, y + 1)
        ?.let { board.checkNotVisited(x, y + 1, visited) }
        ?.let {
            visited.add(board[x][y + 1])
            val candidate = dfs(board, r, c, x, y + 1, depth + 1, visited)
            visited.remove(board[x][y + 1])
            candidate
        }
        ?.let { result = max(result, it) }

    checkRange(r, c, x, y - 1)
        ?.let { board.checkNotVisited(x, y - 1, visited) }
        ?.let {
            visited.add(board[x][y - 1])
            val candidate = dfs(board, r, c, x, y - 1, depth + 1, visited)
            visited.remove(board[x][y - 1])
            candidate
        }
        ?.let { result = max(result, it) }

    return result
}

fun checkRange(r: Int, c: Int, x: Int, y: Int): Boolean? =
    if (x in 0 until r && y in 0 until c) true else null

fun List<String>.checkNotVisited(x: Int, y: Int, visited: Set<Char>): Boolean?
    = if (this[x][y] !in visited) true else null
