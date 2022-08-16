class Heap<T>(
    private val comparator: Comparator<T>
) {
    private val data: MutableList<T> = mutableListOf()

    val size: Int
        get() = data.size

    fun insert(value: T) {
        data.add(value)
        shiftUp(data.size - 1)
    }

    fun pop(): T {
        val last = data.removeLast()
        if (data.isEmpty()) {
            return last
        }
        val first = data[0]
        data[0] = last
        shiftDown(0)
        return first
    }

    private fun shiftUp(index: Int) {
        if (index <= 0) {
            return
        }
        val parentIndex = (index - 1) / 2
        val parentValue = data[parentIndex]
        val value = data[index]
        if (comparator.compare(parentValue, value) < 0) {
            data[parentIndex] = value
            data[index] = parentValue
            shiftUp(parentIndex)
        }
    }

    private fun shiftDown(index: Int) {
        val currentValue = data[index]
        val leftIndex = index * 2 + 1
        val rightIndex = index * 2 + 2
        val left = data.getOrNull(leftIndex)
        val right = data.getOrNull(rightIndex)

        if (left == null && right == null) {
            return
        }

        if (left != null && right == null && comparator.compare(left, currentValue) > 0) {
            data[index] = left
            data[leftIndex] = currentValue
            shiftDown(leftIndex)
            return
        }

        if (left != null && right != null && comparator.compare(right, currentValue) > 0 && comparator.compare(right, left) >= 0) {
            data[index] = right
            data[rightIndex] = currentValue
            shiftDown(rightIndex)
            return
        }

        if (left != null && right != null && comparator.compare(left, currentValue) > 0 && comparator.compare(right, left) <= 0) {
            data[index] = left
            data[leftIndex] = currentValue
            shiftDown(leftIndex)
            return
        }
    }
}

fun main() {
    val n = readln().toInt()
    val result = StringBuilder()
    val maxHeap = Heap<Int> { o1, o2 -> o1 - o2 }
    for(i in 0 until n) {
        val x = readln().toInt()
        if (x == 0) {
            if (maxHeap.size == 0) {
                result.appendLine(0)
            } else {
                result.appendLine(maxHeap.pop())
            }
        } else if (x > 0) {
            maxHeap.insert(x)
        }
    }

    print(result)
}
