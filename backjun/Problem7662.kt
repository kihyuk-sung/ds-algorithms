import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    val results = mutableListOf<String>()
    for (i in 0 until t) {
        val queue = DualPriorityQueue<Int> { o1, o2 -> if (o1 < o2) -1 else if (o1 == o2) 0 else 1 }
        val k = readln().toInt()
        for (j in 0 until k) {
            val row = readln()
            val (o, valueString) = row.split(" ")
            val value = valueString.toInt()

            when(o) {
                "I" -> queue.add(value)
                "D" -> if (value == 1) queue.deleteMax() else queue.deleteMin()
            }
        }
        if (queue.isEmpty()) {
            results.add("EMPTY")
        } else {
            results.add("${queue.max()} ${queue.min()}")
        }
    }

    println(results.joinToString("\n"))
}

class DualPriorityQueue<T>(
    private val comparator: Comparator<T>
) {
    private val minPriorityQueue = PriorityQueue(comparator)
    private val maxPriorityQueue = PriorityQueue(comparator.reversed())
    private val counter: MutableMap<T, Int> = mutableMapOf()

    fun add(data: T) {
        minPriorityQueue.add(data)
        maxPriorityQueue.add(data)
        counter.countUp(data)
    }

    fun deleteMax(): T? = delete(maxPriorityQueue)

    fun deleteMin(): T? = delete(minPriorityQueue)

    private fun delete(queue: PriorityQueue<T>): T? {
        while (queue.isNotEmpty()) {
            val candidate = queue.poll()
            val count = counter[candidate] ?: 0
            if (count != 0) {
                counter.countDown(candidate)
                return candidate
            }
        }

        return null
    }

    fun min(): T? = peek(minPriorityQueue)
    fun max(): T? = peek(maxPriorityQueue)

    private fun peek(queue: PriorityQueue<T>): T? {
        while (queue.isNotEmpty()) {
            val candidate = queue.peek()
            val count = counter[candidate] ?: 0

            if (count != 0) {
                return candidate
            } else {
                queue.poll()
            }
        }
        return null
    }

    fun isEmpty(): Boolean = counter.isEmpty()

    private fun MutableMap<T, Int>.countUp(value: T) {
        val countValue = this[value] ?: 0
        this[value] = countValue + 1
    }

    private fun MutableMap<T, Int>.countDown(value: T) {
        val countValue = this[value]

        if (countValue != null && countValue > 1) {
            this[value] = countValue - 1
            return
        }
        this.remove(value)
    }
}
