import java.io.BufferedReader
import java.io.InputStreamReader

data class Animal(val index: Int, val values: List<Int>)

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val testCases = reader.readLine().toInt()
    repeat(testCases) {
        val (numAnimals, numValues) = reader.readLine().split(" ").map { it.toInt() }.sorted()
        val animals = mutableListOf<Animal>()
        repeat(numAnimals) { i ->
            val cardList = reader.readLine().split(" ").map { it.toInt() }.sorted()
            animals.add(Animal(i, cardList))
        }
        animals.sortBy { it.values[0] }
        var isValid = true
        for (r in 1 until numValues) {
            for (j in 1 until numAnimals) {
                if (animals[j].values[r] <= animals[j - 1].values[r]) {
                    isValid = false
                    break
                }
            }
            if (animals[0].values[r] <= animals[numAnimals - 1].values[r - 1]) {
                isValid = false
            }
            if (!isValid) break
        }
        if (!isValid) {
            println(-1)
        } else {
            println(animals.joinToString(" ") { (it.index + 1).toString() })
        }
    }
}
