fun main() {
    val n = readln().toInt()
    val space = mutableListOf<MutableList<Int>>()
    for (i in 0 until n) {
        val row = readln().split(" ").map { it.toInt() }
        space.add(row.toMutableList())
    }

    println(findBabySharkCanEatFishTime(
        space
    ))
}

fun findBabySharkCanEatFishTime(space: List<MutableList<Int>>): Int {
    var result = 0

    val babyShark = findBabyShark(space, 2)

    while (true) {
        val nextPosition = findMinimumDistance(space, n = space.size, babyShark = babyShark) ?: break

        result += nextPosition.distance
        babyShark.eatFish(nextPosition)
        space[nextPosition.r][nextPosition.c] = 9
    }

    return result
}

class Shark(
    var r: Int,
    var c: Int,
    var size: Int,
) {
    private var eatCount = 0

    fun eatFish(nextPosition: FishPosition) {
        r = nextPosition.r
        c = nextPosition.c

        eatCount += 1
        if (eatCount == size) {
            eatCount = 0
            size += 1
        }
    }
}

fun findBabyShark(space: List<List<Int>>, babySharkSize: Int): Shark {
    space.forEachIndexed { i, row ->
        row.forEachIndexed { j, size ->
            if (size == 9) {
                return Shark(
                    r = i,
                    c = j,
                    size = babySharkSize,
                )
            }
        }
    }

    throw AssertionError("The shark must exist!")
}

fun findMinimumDistance(space: List<MutableList<Int>>, n: Int, babyShark: Shark): FishPosition? {
    val checked = mutableSetOf<FishPosition>()

    val queue = ArrayDeque<FishPosition>()
    val startPosition = FishPosition(
        r = babyShark.r,
        c = babyShark.c,
        distance = 0,
    )

    space[startPosition.r][startPosition.c] = 0

    checked.add(startPosition)
    queue.add(startPosition)

    var result: FishPosition? = null

    while (queue.isNotEmpty()) {
        val currentPosition = queue.removeFirst()

        result = currentPosition
            .checkFishCanEat(space, babyShark.size)
            .checkAndChangeResult(result)

        currentPosition.up(n)
            ?.confirmSize(space, babyShark)
            ?.checkResult(result?.distance)
            ?.setAsCheckedAndAddToQueue(checked, queue)
        currentPosition.left(n)
            ?.confirmSize(space, babyShark)
            ?.checkResult(result?.distance)
            ?.setAsCheckedAndAddToQueue(checked, queue)
        currentPosition.down(n)
            ?.confirmSize(space, babyShark)
            ?.checkResult(result?.distance)
            ?.setAsCheckedAndAddToQueue(checked, queue)
        currentPosition.right(n)
            ?.confirmSize(space, babyShark)
            ?.checkResult(result?.distance)
            ?.setAsCheckedAndAddToQueue(checked, queue)
    }

    return result
}

data class FishPosition(
    val r: Int,
    val c: Int,
    val distance: Int,
) {

    fun up(n: Int): FishPosition? =
        if (r - 1 < 0) null else FishPosition(
            r = r - 1,
            c = c,
            distance = distance + 1,
        )

    fun down(n: Int): FishPosition? =
        if (r + 1 >= n) null else FishPosition(
            r = r + 1,
            c = c,
            distance = distance + 1,
        )

    fun left(n: Int): FishPosition? =
        if (c - 1 < 0) null else FishPosition(
            r = r,
            c = c - 1,
            distance = distance + 1,
        )

    fun right(n: Int): FishPosition? =
        if (c + 1 >= n) null else FishPosition(
            r = r,
            c = c + 1,
            distance = distance + 1,
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FishPosition

        if (r != other.r) return false
        if (c != other.c) return false

        return true
    }

    override fun hashCode(): Int {
        var result = r
        result = 31 * result + c
        return result
    }
}

fun FishPosition.checkResult(resultDistance: Int?): FishPosition? = if (resultDistance != null && this.distance > resultDistance) null else this

fun FishPosition.confirmSize(space: List<List<Int>>, babyShark: Shark): FishPosition? = this.let {
    if (space[it.r][it.c] <= babyShark.size) {
        it
    } else null
}

fun FishPosition.setAsCheckedAndAddToQueue(checked: MutableSet<FishPosition>, queue: ArrayDeque<FishPosition>) {
    this.let {
        if (checked.add(it)) queue.add(it)
    }
}

fun FishPosition.checkFishCanEat(space: List<List<Int>>, sharkSize: Int): FishPosition? =
    if (space[this] in 1 until sharkSize) {
        this
    } else null

fun FishPosition?.checkAndChangeResult(previousPosition: FishPosition?): FishPosition? =
    if (this != null && (previousPosition == null
        || previousPosition.distance > this.distance
        || previousPosition.distance == this.distance && previousPosition.r > this.r
        || previousPosition.distance == this.distance && previousPosition.r == this.r && previousPosition.c > this.c)
    ) this
    else previousPosition

operator fun List<List<Int>>.get(position: FishPosition): Int = this[position.r][position.c]
