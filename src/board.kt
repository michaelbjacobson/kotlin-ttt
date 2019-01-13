class Board {

    var tiles: MutableList<String> = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    var winningCombos: List<List<Int>> = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
        listOf(0, 4, 8), listOf(2, 4, 6)
    )

    fun format(): String {
        return """
          ${ tiles[0] } | ${ tiles[1] } | ${ tiles[2] }
         ---+---+---
          ${ tiles[3] } | ${ tiles[4] } | ${ tiles[5] }
         ---+---+---
          ${ tiles[6] } | ${ tiles[7] } | ${ tiles[8] }
         """
    }

    fun corners(): List<Int> {
        return listOf(0, 2, 6, 8)
    }

    fun updateTile(index: Int, symbol: String) {
        tiles[index] = symbol
    }

    fun resetTile(index: Int) {
        tiles[index] = (index + 1).toString()
    }

    fun availableTileIndices(): Array<Int> {
        return tiles.indices.filter { tiles[it].isNumeric() }.toTypedArray()
    }

    fun isFull(): Boolean {
        return availableTileIndices().count() == 0
    }

    fun isEmpty(): Boolean {
        return availableTileIndices().count() == 9
    }

}
