fun main() {
    val n = readln().toInt()
    val inorder = readln().split(" ").map { it.toInt() }
    val postorder = readln().split(" ").map { it.toInt() }

    val result = mutableListOf<Int>()
    preorder(inorder, postorder, 0, n, 0, n, result)

    println(result.joinToString(" "))
}

fun preorder(inorder: List<Int>, postorder: List<Int>, inStart: Int, inEnd: Int, postStart: Int, postEnd: Int, result: MutableList<Int>) {
    if (inStart >= inEnd || postStart >= postEnd) {
        return
    }

    val root = postorder[postEnd - 1]
    result.add(root)

    val index = inorder.indexOf(root)
    val length = index - inStart

    preorder(inorder, postorder, inStart = inStart, inEnd = inStart + index, postStart = postStart, postEnd = postStart + length, result)
    preorder(inorder, postorder, inStart = index + 1, inEnd = inEnd, postStart = postStart + length, postEnd = postEnd - 1, result)
}
