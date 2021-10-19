class Hiro(override val name: String): Person(name) {
    fun talk() {
        println("how can I help?")
    }
}