open class Person(open val name: String) {
    fun introduce() {
        println("Hello I am " + name)
    }
}