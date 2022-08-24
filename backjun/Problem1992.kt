fun main() {
    val n = readln().toInt()
    val image = mutableListOf<List<Int>>()
    for (i in 0 until n) {
        val r = readln().toCharArray().map { it.digitToInt() }
        image.add(r)
    }

    println(quadTree(image, 0, 0, n))
}

fun quadTree(image: List<List<Int>>, startRowIndex: Int, startColIndex: Int, n: Int): String {
    val initData = image[startRowIndex][startColIndex]
    if (n == 1) {
        return initData.toString()
    }

    var itCanCompress = true
    for (rowIndex in startRowIndex until startRowIndex + n) {
        val row = image[rowIndex]
        for (colIndex in startColIndex until startColIndex + n) {
            val data = row[colIndex]
            if (data != initData) {
                itCanCompress = false
                break
            }
        }
        if (!itCanCompress) {
            break
        }
    }

    if (itCanCompress) {
        return initData.toString()
    }

    val halfN = n / 2
    return "(${quadTree(image, startRowIndex, startColIndex, halfN)}${
        quadTree(
            image,
            startRowIndex,
            startColIndex + halfN,
            halfN
        )
    }${quadTree(image, startRowIndex + halfN, startColIndex, halfN)}${
        quadTree(
            image,
            startRowIndex + halfN,
            startColIndex + halfN,
            halfN
        )
    })"
}
