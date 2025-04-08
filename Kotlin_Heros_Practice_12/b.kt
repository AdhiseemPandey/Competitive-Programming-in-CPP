/**************KOTLIN***************/



// import java.util.*

// fun main() {
//     val scanner = Scanner(System.`in`)
//     val t = scanner.nextInt()
    
//     repeat(t) {
//         val n = scanner.nextInt()
//         val s = scanner.next()
        
//         val countDash = s.count { it == '-' }
//         val countUnderscore = s.count { it == '_' }
        
//         val maxSubsequences = countDash * countUnderscore * (countDash - 1) / 2
//         println(maxSubsequences)
//     }
// }


/******************CPP****************/
// #include <iostream>
// #include <string>
// using namespace std;

// int countSubsequences(string s) {
//     long long countDash = 0, countUnderscore = 0;
//     for (char c : s) {
//         if (c == '-') countDash++;
//         else if (c == '_') countUnderscore++;
//     }
//     return countDash * (countDash - 1) / 2 * countUnderscore;
// }

// int main() {
//     int t;
//     cin >> t;
    
//     while (t--) {
//         int n;
//         cin >> n;
//         string s;
//         cin >> s;
        
//         cout << countSubsequences(s) << "\n";
//     }
    
//     return 0;
// }


package org.example

fun main() {
    val testCaseCount = readln().toInt()
    for (i in 1..testCaseCount) {
        val length = readln().toInt()
        val inputString = readln()
        
        if (length < 3) {
            println(0)
            continue
        }

        var dashCount: Long = 0
        var underscoreCount: Long = 0
        
        for (char in inputString) {
            if (char == '-') {
                dashCount += 1
            }
            if (char == '_') {
                underscoreCount += 1
            }
        }
        
        if (dashCount < 2 || underscoreCount < 1) {
            println(0)
            continue
        }
        
        val left = dashCount / 2
        val right = dashCount - left
        
        println(underscoreCount * left * right)
    }
}
