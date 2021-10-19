fun main() {
    val hira = Student("Hira")
    val monica = Comedian("Monica")
    val bert = Teacher("Bert")
    val poeple = arrayOf(hira, monica, bert)
    val random = poeple.random()
    random.introduce()

    hira.test()
    monica.tellJoke()
    bert.funFact()
}