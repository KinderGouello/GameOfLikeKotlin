package com.kata.gameoflife.unit

import com.kata.gameoflife.domain.Cell
import com.kata.gameoflife.domain.CellState
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class CellTest {

    @Test
    fun `returns true if the cell is alive`() {
        val cell = Cell(CellState.LIVE)

        assertTrue(cell.isAlive())
    }

    @Test
    fun `returns false if the cell is dead`() {
        val cell = Cell(CellState.DEAD)

        assertFalse(cell.isAlive())
    }

    @Test
    fun `a living cell should die if it has less than 2 living neighbours`() {
        val cell = Cell()

        assertSame(cell.nextCellState(1), CellState.DEAD)
    }

    @Test
    fun `a living cell should die if it has more than 3 living neighbours`() {
        val cell = Cell()

        assertSame(cell.nextCellState(4), CellState.DEAD)
    }

    @Test
    fun `a living cell should live if it has 2 living neighbours`() {
        val cell = Cell()

        assertSame(cell.nextCellState(2), CellState.LIVE)
    }

    @Test
    fun `a living cell should live if it has 3 living neighbours`() {
        val cell = Cell()

        assertSame(cell.nextCellState(3), CellState.LIVE)
    }

    @Test
    fun `a dead cell should live if it has 3 living neighbours`() {
        val cell = Cell(CellState.DEAD)

        assertSame(cell.nextCellState(3), CellState.LIVE)
    }

    @Test
    fun `a dead cell should still be dead if it has not 3 living neighbours`() {
        val cell = Cell(CellState.DEAD)

        assertSame(cell.nextCellState(2), CellState.DEAD)
    }
}