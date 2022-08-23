fun main() {
    val n = readln().toInt()
    val meetings = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        meetings.add(start to end)
    }

    println(maxMeetings(meetings))
}

fun maxMeetings(meetings: List<Pair<Int, Int>>): Int {
    var last: Pair<Int, Int>? = null
    var result = 0
    for (m in meetings.sortedWith(compareBy<Pair<Int, Int>> { it.second }.then(compareBy { it.first }))) {
        if (m.first >= (last?.second ?: 0)) {
            last = m
            result++
        }
    }
    return result
}
