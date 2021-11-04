fun main() {
    val hira = Student("Hira")
    val monica = Comedian("Monica")
    val bert = Teacher("Bert")
    val poeple = arrayOf(hira, monica, bert, ChatBot())
    val random = poeple.random()
    random.introduce()
    random.talk()

    // array<Person>
    // Person --> introduce & talk

    // Array<class>
    // class --> ??

    // array<ChatPartner>
    // chatPartner --> introduce & talk



    //hira.test()
    //monica.tellJoke()
    //bert.funFact()
}