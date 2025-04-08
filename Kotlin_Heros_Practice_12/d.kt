import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val testCases = reader.readLine().toInt()
    val output = StringBuilder()
    repeat(testCases) {
        val (sizeStr, minValueStr, maxValueStr) = reader.readLine().split(" ")
        val size = sizeStr.toInt()
        val minValue = minValueStr.toLong()
        val maxValue = maxValueStr.toLong()
        val numbers = reader.readLine().split(" ").map { it.toLong() }.toMutableList()
        numbers.sort()
        val totalSum = numbers.sum()
        val lowerLimit = totalSum - maxValue
        val upperLimit = totalSum - minValue

        fun countValidPairs(limit: Long): Long {
            var pairCount = 0L
            var left = 0
            var right = size - 1
            while (left < right) {
                if (numbers[left] + numbers[right] <= limit) {
                    pairCount += (right - left)
                    left++
                } else {
                    right--
                }
            }
            return pairCount
        }

        val result = countValidPairs(upperLimit) - countValidPairs(lowerLimit - 1)
        output.append(result).append("\n")
    }
    print(output)
}
