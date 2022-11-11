fun main() {
    val (n, m) = readNumbers()

    val a = getMatrix(n)
    val b = getMatrix(n)

    val c = matrixSum(a, b, n, m)

    println(
        c.joinToString("\n") {
            it.joinToString(" ")
        }
    )
}

fun readNumbers() = readln().split(" ").map { it.toInt() }

fun getMatrix(n: Int) = buildList {
    for (i in 0 until n) {
        add(readNumbers())
    }
}

fun matrixSum(a: List<List<Int>>, b: List<List<Int>>, n: Int, m: Int) = buildList {
    for (i in 0 until n) {
        add(
            buildList {
                for (j in 0 until m) {
                    add(a[i][j] + b[i][j])
                }
            }
        )
    }
}
