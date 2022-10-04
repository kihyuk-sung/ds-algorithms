fun main() {
    val n = readln().toInt()

    val paper = makePaper(n)
    paper.drawStar(0, 0, n)

    print(buildString {
        paper.forEach {
            append(it)
            append('\n')
        }
    })

}

const val STAR = '*'

fun List<CharArray>.drawStar(r: Int, c: Int, n: Int) {
    if (n == 3) {
        this[r + 0][c + 2] = STAR
        this[r + 1][c + 1] = STAR
        this[r + 1][c + 3] = STAR
        this[r + 2][c + 0] = STAR
        this[r + 2][c + 1] = STAR
        this[r + 2][c + 2] = STAR
        this[r + 2][c + 3] = STAR
        this[r + 2][c + 4] = STAR
        return
    }

    val nextN = n / 2
    this.drawStar(r, c + nextN, nextN)
    this.drawStar(r + nextN, c, nextN)
    this.drawStar(r + nextN, c + nextN * 2, nextN)
}

fun makePaper(n: Int): List<CharArray> = buildList {
    val col = calculateCol(n)
    for (i in 0 until n) {
        add(CharArray(col) { ' ' })
    }
}

fun calculateCol(n: Int): Int {
    if (n == 3) {
        return 5
    }

    return calculateCol(n / 2) * 2 + 1
}
