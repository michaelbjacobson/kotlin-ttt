class Game {

    var board: Board = Board()
    var players: List<Player> = listOf(Computer("O"), Human("X"))

    fun play() {
        displayBoard()
        while (!isOver()) {
            takeTurn()
        }
        displayGamOverMessage()
    }

    fun currentPlayer(): Player {
        return if (board.availableTileIndices().count().isEven()) {
            secondPlayer()
        } else {
            firstPlayer()
        }
    }

    fun isWon(): Boolean {
        return isWonBy(firstPlayer()) || isWonBy(secondPlayer())
    }

    fun isOver(): Boolean {
        return isWon() || isTied()
    }

    private fun isTied(): Boolean {
        return board.isFull() && !isWon()
    }

    private fun takeTurn() {
        board.updateTile(currentPlayer().move(this), currentPlayer().symbol)
        displayBoard()
    }

    private fun isWonBy(player: Player): Boolean {
        for (combo: List<Int> in board.winningCombos) {
            if (combo.all { index -> board.tiles[index] == player.symbol }) {
                return true
            }
        }
        return false
    }

    private fun winner(): Player {
        return if (isWonBy(firstPlayer())) {
            firstPlayer()
        } else {
            secondPlayer()
        }
    }

    private fun displayBoard() {
        println(board.format())
    }

    private fun firstPlayer(): Player {
        return players.first()
    }

    private fun secondPlayer(): Player {
        return players.last()
    }

    private fun displayGamOverMessage() {
        if (isWon()) {
            println("${ winner().symbol } wins!")
        } else {
            println("Tie game!")
        }
    }

}