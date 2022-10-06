fun main() {
    val numbers = generateSequence {
        readLine()?.toIntOrNull()
    }.toList()

    val result = mutableListOf<Int>()
    numbers.postOrder(0, numbers.size, result)

    println(result.joinToString(separator = "\n"))
}

fun List<Int>.postOrder(start: Int, end: Int, result: MutableList<Int>) {
    if (start >= end) {
        return
    }
    if (start == end -1) {
        result.add(this[start])
        return
    }

    val mid = this.findMid(start, end)

    this.postOrder(start + 1, mid, result)
    this.postOrder(mid, end, result)

    result.add(this[start])
}

fun List<Int>.findMid(start: Int, end: Int): Int {
    val root = this[start]
    for (i in start + 1 until end) {
        if (root < this[i]) {
            return i
        }
    }
    return end
}
