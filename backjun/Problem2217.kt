fun main() {
    val n = readln().toInt()

    val list = buildList {
        for (i in 0 until n) {
            add(readln().toInt())
        }
    }.sorted()

    val max = buildList {
        list.forEachIndexed { index, rope ->
            add(rope * (list.size - index))
        }
    }
    
    println(max.maxOrNull() ?: 0)
}
