fun main() {
    println("test")
    challengeOne()
}

// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/
// https://www.tutorialkart.com/kotlin/kotlin-set-contains/
// https://www.tutorialkart.com/kotlin/kotlin-string-capitalize-first-letter-uppercased-example/
fun challengeOne() {
    val name = setOf("Rachel", "Ben", "Sue")

    print("Can you give me a person in Friends? ")
    var answer = readLine().toString()
    answer = answer.capitalize()

   if(name.contains(answer)) {
       success()
   } else {
       gameOver()
   }
}

fun gameOver() {
    println("Wrong Answer")
}

fun success() {
    println("It works")
}