class Human(override var symbol: String) : Player {

    override fun move(game: Game): Int {
        val input = readLine()!!
        return (input.toInt() - 1)
    }

}