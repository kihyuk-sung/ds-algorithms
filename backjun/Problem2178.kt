fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val maze = mutableListOf<List<Int>>()
    for (i in 0 until n) {
        val r = readln().toCharArray().map { it.digitToInt() }
        maze.add(r)
    }

    println(travelMaze(maze, n, m))
}

fun travelMaze(maze: List<List<Int>>, n: Int, m: Int): Int {
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(0, 0, 1))
    val visited = mutableSetOf<Pair<Int, Int>>()
    visited.add(0 to 0)

    while (queue.isNotEmpty()) {
        val (r, c, d) = queue.removeFirst()
        if (r == n - 1 && c == m - 1) {
            return d
        }

        checkAndVisit(maze, r, c + 1, d + 1, visited, queue)
        checkAndVisit(maze, r, c - 1, d + 1, visited, queue)
        checkAndVisit(maze, r + 1, c, d + 1, visited, queue)
        checkAndVisit(maze, r - 1, c, d + 1, visited, queue)
    }

    return 0
}

fun check(maze: List<List<Int>>, r: Int, c: Int, visited: Set<Pair<Int, Int>>): Boolean
    = maze.getOrNull(r)?.getOrNull(c) == 1 && r to c !in visited

fun checkAndVisit(maze: List<List<Int>>, r: Int, c: Int, d: Int, visited: MutableSet<Pair<Int, Int>>, queue:ArrayDeque<Triple<Int, Int, Int>>) {
    if (check(maze, r, c, visited)) {
        visited.add(r to c)
        queue.add(Triple(r, c, d))
    }
}
