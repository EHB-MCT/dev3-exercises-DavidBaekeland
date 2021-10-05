// https://www.geeksforgeeks.org/kotlin-array/
var poeple = arrayOf("Hira", "Jens", "Jasmien", "Tyron", "Stijn")

fun main () {
    println("Hello World")
    printNames()
}

fun printNames () {
    // https://stackoverflow.com/questions/10227408/foreach-in-kotlin
    for(name in poeple) {
        println("Hello " + name)
    }
}
