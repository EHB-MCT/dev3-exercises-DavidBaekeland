class Duolingo(val size: Int = 5, val language: String="eng") {
    var words = mutableSetOf<Word>(
        EnglishWord("Hello", 1, "hallo"),
        FrenchWord("Bonjour", 1, "hallo"),
        EnglishWord("language", 1, "taal"),
        FrenchWord("langue", 2, "taal"),
        FrenchWord("glace", 1,"ijs"),
        EnglishWord("contact", 2,"contact"),
        EnglishWord("water", 2, "water"),
        FrenchWord("l'eau", 1, "water"),
        FrenchWord("navigateur", 2, "browser"),
        EnglishWord("form", 1, "formulier")
    )

    // magic functie => automatich

    // https://kotlinlang.org/docs/collections-overview.html#collection
    fun play2()  {
        var wordDeck2 = WordDeck(words)
        println(wordDeck2.toString())
        val randomWords = words.shuffled().take(size).toMutableSet()
        //.shuffled = > zodat we niet elke keer 5 dezelfde hebben
        // .take() => aantal items
        // .toMutableSet => zodat een item kan worden weggehaald

        while (randomWords.isNotEmpty())  {
            val selectedWord = randomWords.random()
            println(selectedWord.difficulty)
            println(selectedWord.original)
            val answer = readLine()


            if(answer == selectedWord.translated)  {
                randomWords.remove(selectedWord)
                if (selectedWord.difficulty > 1) {
                    selectedWord.difficulty--
                } else {
                    throw Exception("The difficulty is to low")
                }
            }  else  {
                println("Het juiste antwoord was ${selectedWord.translated}")
                selectedWord.difficulty += 2
            }

            println("Count: ${randomWords.count()}")
        }
    }
}