// open: mogen overerven
// public: standaard: iedereen mag het gebruiken
// private: alleen person zelf
// protected: wel teacher, student, Comedian -> niet main
open class Person(open val name: String): ChatPartner {
    override fun introduce() {
        println("Hello I am ${name}")
    }

    override fun talk() {

    }
}