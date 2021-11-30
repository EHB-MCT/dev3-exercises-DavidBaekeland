class Duolingo {
    init  {
        val word1 = Word("Hello", "hallo", "eng")
        val word2 = Word("Bonjour", "hallo", "fr")
        val word3 = Word("language", "taal", "eng")
        val word4 = Word("langue", "taal", "fr")
        val word5 = Word("glace", "ijs", "fr")
        val word6 = Word("contact", "contact", "eng")
        val word7 = Word("water", "water", "eng")
        val word8 = Word("l'eau", "water", "fr")
        val word9 = Word("navigateur", "browser", "fr")
        val word10 = Word("form", "formulier", "eng")
        val words = mutableListOf<Word>(word1, word2, word3, word4, word5, word6, word7, word8, word9, word10)


        play(words)

    }


    // https://kotlinlang.org/docs/collections-overview.html#collection
    fun play(words: List<Word>)  {
        val randomWords = words.shuffled().take(5).toMutableSet()
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