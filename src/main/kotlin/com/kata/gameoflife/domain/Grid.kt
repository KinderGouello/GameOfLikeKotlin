package com.kata.gameoflife.domain

typealias Position = Pair<Int, Int>
typealias Cells = LinkedHashMap<Position, Cell>

class Grid(private val cells: Cells) {
    fun nextGeneration(): Grid {
        val newCells: Cells = linkedMapOf()
        cells.asIterable().forEach{ (position, cell) ->
            val neighbours = getNeighbours(position)
            val numberOfLivedCells = neighbours.fold(0) { sum, neighbourCell ->
                if (neighbourCell != null && neighbourCell.isAlive()) sum + 1 else sum
            }

            newCells[Pair(position.first, position.second)] = Cell(cell.nextCellState(numberOfLivedCells))
        }
        return Grid(newCells)
    }

    fun getCells(): Cells {
        return cells
    }

    private fun getNeighbours(position: Position): List<Cell?> {
        return arrayOf(
                Pair(position.first - 1, position.second - 1),
                Pair(position.first - 1, position.second),
                Pair(position.first - 1, position.second + 1),
                Pair(position.first, position.second - 1),
                Pair(position.first, position.second + 1),
                Pair(position.first + 1, position.second - 1),
                Pair(position.first + 1, position.second),
                Pair(position.first + 1, position.second + 1)
        ).map {
            cells[it]
        }
    }
}
