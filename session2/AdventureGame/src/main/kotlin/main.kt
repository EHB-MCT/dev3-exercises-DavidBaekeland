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
       challengeTwo()
   } else {
       gameOver()
   }
}

// https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin
fun challengeTwo() {
    val random = (1..6).random()
    println(random)

    print("Is the following number low or high? ")

    val answer = readLine()

    // random <= 3 || random >=4
    if((1..3).contains(random) && answer == "low") {
        success()
    } else if ((4..6).contains(random) && answer == "high")  {
        success()
    } else {
        gameOver()
    }


}

fun gameOver() {
    println("Wrong Answer")
}

fun success() {
    println("You won")
}