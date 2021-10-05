// https://www.geeksforgeeks.org/kotlin-array/
var poeple = arrayOf("Hira", "Jens", "Jasmien", "Tyron", "Stijn")

fun main () {
    println("Hello World")
    // https://stackoverflow.com/questions/10227408/foreach-in-kotlin
    // for(name in poeple) {
    //printNames(name)
    //}

    randomNumber()
}

fun printNames (name: String) {
    println("Hello $name")
}

fun randomNumber () {
    //https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin
    // val randomNumber = (0..2).random() -> Je kan random gebruiken op alle array
    val options = arrayOf("rock", "paper", "scissors").random()
    println(options)
    askOption(options)
}

fun askOption (options: String) {
    // https://beginnersbook.com/2018/09/kotlin-input-from-user/
    print("Wich option?")
    var answer = readLine()
    if(answer == options)  {
        println("You won")
    } else {
        println("Sorry. Wrong answer")
    }

}
