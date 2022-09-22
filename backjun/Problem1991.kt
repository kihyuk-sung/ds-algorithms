fun main() {
    val n = readln().toInt()

    val graph: MutableMap<String, Pair<String, String>> = mutableMapOf()

    for (i in 0 until n) {
        val (root, left, right) = readln().split(" ")
        graph[root] = left to right
    }

    println(graph.preorder("A"))
    println(graph.inorder("A"))
    println(graph.postorder("A"))
}

val EMPTY = "." to "."


fun MutableMap<String, Pair<String, String>>.preorder(node: String): String {
    if (node == ".") {
        return ""
    }

    val (left, right) = this[node] ?: EMPTY

    return "$node${this.preorder(left)}${this.preorder(right)}"
}

fun MutableMap<String, Pair<String, String>>.inorder(node: String): String {
    if (node == ".") {
        return ""
    }

    val (left, right) = this[node] ?: EMPTY

    return "${this.inorder(left)}$node${this.inorder(right)}"
}

fun MutableMap<String, Pair<String, String>>.postorder(node: String): String {
    if (node == ".") {
        return ""
    }

    val (left, right) = this[node] ?: EMPTY

    return "${this.postorder(left)}${this.postorder(right)}$node"
}

fun MutableMap<String, Pair<String, String>>.travel(node: String, order: MutableMap<String, Pair<String, String>>.(node: String, left:String, right: String) -> String): String {
    if (node == ".") {
        return ""
    }

    val (left, right) = this[node] ?: EMPTY

    return this.order(node, left, right)
}
