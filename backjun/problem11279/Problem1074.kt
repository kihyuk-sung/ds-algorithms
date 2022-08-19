fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    println(travel(n = n, r = r, c = c))
}

fun travel(n: Int, r: Int, c: Int): Int {
    if (n == 1) {
        return r * 2 + c
    }

    val max = 1 shl n
    val half = max shr 1

    if (r in 0 until half && c in 0 until half) {
        return travel(n = n - 1, r = r, c = c)
    }

    if (r in 0 until half && c in half until max) {
        return travel(n = n - 1, r = r, c = c - half) + half * half
    }

    if (r in half until max && c in 0 until half) {
        return travel(n = n - 1, r = r - half, c = c) + half * half * 2
    }

    if (r in half until max && c in half until max) {
        return travel(n = n - 1, r = r - half, c = c - half) + half * half * 3
    }
    return 0
}
