package com.kata.gameoflife.domain

class Cell(private val state: CellState = CellState.LIVE) {

    fun isAlive(): Boolean {
        return state === CellState.LIVE
    }

    fun nextCellState(numberOfLivingNeighbours: Int): CellState {
        return when {
            state === CellState.LIVE && (numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3) -> CellState.LIVE
            state === CellState.DEAD && numberOfLivingNeighbours == 3 -> CellState.LIVE
            else -> CellState.DEAD
        }
    }

    override fun hashCode(): Int {
        return state.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Cell) {
            return state == other.state
        }
        return super.equals(other)
    }
}
