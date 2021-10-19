class Student(override val name: String): Person(name) {
    fun test() {
        println("Student")
    }
}