class Duolingo(val size: Int = 5, val language: String="eng") {
    init  {
        //val word1 = Word("Hello", "hallo", "eng")
        //val word2 = Word("Bonjour", "hallo", "fr")
        //val word3 = Word("language", "taal", "eng")
        //val word4 = Word("langue", "taal", "fr")
        //val word5 = Word("glace", "ijs", "fr")
        //val word6 = Word("contact", "contact", "eng")
        //val word7 = Word("water", "water", "eng")
        //val word8 = Word("l'eau", "water", "fr")
        //val word9 = Word("navigateur", "browser", "fr")
        //val word10 = Word("form", "formulier", "eng")
        //val words = mutableListOf<Word>(word1, word2, word3, word4, word5, word6, word7, word8, word9, word10)

        val word1 = EnglishWord("Hello", "hallo")
        val word2 = FrenchWord("Bonjour", "hallo")
        val word3 = EnglishWord("language", "taal")
        val word4 = FrenchWord("langue", "taal")
        val word5 = FrenchWord("glace", "ijs")
        val word6 = EnglishWord("contact", "contact")
        val word7 = EnglishWord("water", "water")
        val word8 = FrenchWord("l'eau", "water")
        val word9 = FrenchWord("navigateur", "browser")
        val word10 = EnglishWord("form", "formulier")
        val words = mutableListOf<Word2>(word1, word2, word3, word4, word5, word6, word7, word8, word9, word10)


        println(size)
        print(language)

        val filter = words.filter { it.language == language }
        // filter.forEach { println(it.original) }
        play2(filter)

    }

    // https://kotlinlang.org/docs/collections-overview.html#collection
    fun play2(words: List<Word2>)  {
        val randomWords = words.shuffled().take(size).toMutableSet()
        //.shuffled = > zodat we niet elke keer 5 dezelfde hebben
        // .take() => aantal items
        // .toMutableSet => zodat een item kan worden weggehaald

        while (randomWords.isNotEmpty())  {
            val selectedWord = randomWords.random()
            println(selectedWord.original)
            val answer = readLine()


            if(answer == selectedWord.translated)  {
                randomWords.remove(selectedWord)
            }  else  {
                println("Het juiste antwoord was ${selectedWord.translated}")
            }

            println("Count: ${randomWords.count()}")
        }
    }
}