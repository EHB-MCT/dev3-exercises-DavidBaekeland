class WordDeck(var words: Set<Word>) {
    fun filterByLanguage(language: String)  {
        words = words.filter { it.language == language }.toMutableSet()
    }
    fun filterByDifficulty(diffuclty: Int)  {
        words = words.filter { it.difficulty == diffuclty }.toMutableSet()
    }

}