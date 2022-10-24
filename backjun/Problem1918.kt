fun main() {
    val expression = readln()

    println(postfix(expression))
}

fun postfix(expression: String): String = buildString {
    val stack = mutableListOf<Char>()
    for (c in expression) {
        if (c in 'A'..'Z') {
            append(c)
            continue
        }

        if (c == '(') {
            stack.add(c)
            continue
        }

        if (c == '+' || c == '-' || c == '*' || c == '/') {
            while (stack.lastOrNull() != null && c isHigherOrEqual stack.last()) {
                append(stack.removeLast())
            }
            stack.add(c)
            continue
        }

        if (c == ')') {
            while (stack.lastOrNull() != '(') {
                append(stack.removeLast())
            }
            stack.removeLastOrNull()
        }
    }

    while (stack.isNotEmpty()) {
        append(stack.removeLast())
    }
}

infix fun Char.isHigherOrEqual(other: Char): Boolean = if (other != '+' && other != '-' && other != '*' && other != '/') {
    false
} else this == '+' || this == '-' || other == '*' || other == '/'
