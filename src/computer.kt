class Computer(override var symbol: String) : Player {

    override fun move(game: Game): Int {
        return if (game.board.isEmpty()) {
            openingGambit(game)
        } else {
            miniMax(game)
        }
    }

    private fun openingGambit(game: Game): Int {
        return game.board.corners().shuffled().first()
    }

    private fun miniMax(game: Game, depth: Int = 0, scoresMap: MutableMap<Int, Int> = mutableMapOf()): Int {
        return if (game.isOver()) {
            heuristicValue(game)
        } else {
            game.board.availableTileIndices().forEach {
                game.board.updateTile(it, game.currentPlayer().symbol)
                scoresMap[it] = (-1 * miniMax(game, (depth + 1), mutableMapOf()))
                game.board.resetTile(it)
            }
            if (depth == 0) {
                bestMove(scoresMap)
            } else {
                bestScore(scoresMap)
            }
        }
    }

    private fun bestMove(scoresMap: MutableMap<Int, Int>): Int {
        return scoresMap.maxBy { it.value }!!.key
    }

    private fun bestScore(scoresMap: MutableMap<Int, Int>): Int {
        return scoresMap.maxBy { it.value }!!.value
    }

    private fun heuristicValue(game: Game): Int {
        return if (game.isWon()) {
            -1
        } else {
            0
        }
    }

}
