class Teacher(override val name: String): Person(name) {
    fun funFact() {
        println("Teacher")
    }
}