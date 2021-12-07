fun main()  {
    println("Wich level do you want to play?")
    val answer = readLine().toString()
    if(answer != "difficult" && answer != "easy")  {
        throw Exception("Please provide a valid level. Easy or difficult")
    } else  {
        val Duolingo = Duolingo(5,"fr")
        Duolingo.play2()
    }

}