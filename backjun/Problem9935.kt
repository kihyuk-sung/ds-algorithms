fun main() {
    val str = readln()
    val explode = readln()

    println(explodeCharSequence(str, explode))
}

const val FRULA = "FRULA"

fun explodeCharSequence(str: String, explode: String): String {
    val stack = mutableListOf<Char>()

    for (c in str) {
        stack.add(c)
        if (c == explode.last() && stack.canExplode(explode)) {
            stack.explode(explode)
        }
    }

    if (stack.isEmpty()) {
        return FRULA
    }

    return String(stack.toCharArray())
}

fun MutableList<Char>.explode(explode: String) {
    for (i in explode.indices) {
        this.removeLast()
    }
}

fun MutableList<Char>.canExplode(explode: String): Boolean {
    if (this.size < explode.length) {
        return false
    }

    for (i in explode.indices) {
        if (this[this.size - explode.length + i] != explode[i]) {
            return false
        }
    }
    return true
}
