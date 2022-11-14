fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        
        if (a == 0 && b == 0) {
            return
        }
        
        if (a > b) {
            println("Yes")
        } else {
            println("No")
        }
        
    }
}
