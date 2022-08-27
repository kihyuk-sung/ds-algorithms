fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val s = readln()

    println(ioi(s, n))
}

fun ioi(s: String, n: Int): Int {
    var charState = IOI.NULL
    var iterateState = 0
    var result = 0
    for (c in s) {
        charState = charState.next(c)
        iterateState = charState.nextIterateState(iterateState)
        result = charState.nextResult(iterateState, n, result)
    }

    return result
}

enum class IOI {
    NULL, I, O, IEnd;

    fun next(c: Char): IOI = when (c) {
        'I' -> when(this) {
            NULL -> I
            O -> IEnd
            IEnd -> I
            I -> I
        }
        'O' -> when(this) {
            I -> O
            IEnd -> O
            NULL -> NULL
            O -> NULL
        }
        else -> NULL
    }

    fun nextIterateState(iterateState: Int): Int = when(this) {
        NULL -> 0
        I -> 0
        IEnd -> iterateState + 1
        O -> iterateState
    }

    fun nextResult(iterateState: Int, n: Int, result: Int) = when(this) {
        IEnd -> if (iterateState >= n) result + 1 else result
        else -> result
    }
}
