import kotlin.math.abs
import kotlin.math.min

fun main() {
    val targetChannel = readln().toInt()
    val brokenButtonsNumber = readln().toInt()
    val brokenButtons: Set<Int> = if (brokenButtonsNumber == 0) setOf()
        else readln().split(" ").mapTo(mutableSetOf()) { it.toInt() }

    println(remoteController(targetChannel, brokenButtons))
}

fun remoteController(targetChannel: Int, brokenButtons: Set<Int>): Int {
    val currentChannel = 100
    val numbers = 0..9
    val availableButtons = numbers.filter { it !in brokenButtons }

    var result = abs(targetChannel - currentChannel)
    if (availableButtons.isEmpty()) {
        return result
    }

    for (b in availableButtons) {
        result = min(result, foo(targetChannel, availableButtons, b, 1))
    }

    return result
}

fun foo(targetChannel: Int, availableButtons: Collection<Int>, currentChannel: Int, i: Int): Int {
    var result = abs(targetChannel - currentChannel) + i
    
    if (i > 6) {
        return result
    }


    for (b in availableButtons) {
        result = min(result, foo(targetChannel, availableButtons, currentChannel = currentChannel * 10 + b, i + 1))
    }

    return result
}
