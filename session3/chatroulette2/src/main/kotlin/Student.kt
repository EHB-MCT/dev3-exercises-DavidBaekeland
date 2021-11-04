class Student(override val name: String): Person(name), ChatPartner {
    override fun talk() {
        test()
    }
    fun test() {
        println("Student")
    }
}