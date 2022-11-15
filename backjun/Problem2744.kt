fun main() {
    val str = readln()

    println(convertLowerUpper(str))
}

fun convertLowerUpper(str: String): String = buildString {
    str.forEach {
        append(
            if (it.isLowerCase()) {
                it.uppercase()
            } else {
                it.lowercase()
            }
        )
    }
}
