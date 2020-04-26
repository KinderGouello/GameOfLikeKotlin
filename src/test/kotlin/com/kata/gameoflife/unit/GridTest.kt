package com.kata.gameoflife.unit

import com.kata.gameoflife.domain.Cell
import com.kata.gameoflife.domain.CellState
import com.kata.gameoflife.domain.Cells
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GridTest {
    @Test
    fun `should generate next generation for a grid`() {
        // GIVEN
        // X..
        // .X.
        // ..X
        val cells: Cells = linkedMapOf(
                Pair(0, 0) to Cell(),
                Pair(0, 1) to Cell(CellState.DEAD),
                Pair(0, 2) to Cell(CellState.DEAD),
                Pair(1, 0) to Cell(CellState.DEAD),
                Pair(1, 1) to Cell(),
                Pair(1, 2) to Cell(CellState.DEAD),
                Pair(2, 0) to Cell(CellState.DEAD),
                Pair(2, 1) to Cell(CellState.DEAD),
                Pair(2, 2) to Cell()
        )
        val grid = com.kata.gameoflife.domain.Grid(cells)

        // WHEN
        val newGrid = grid.nextGeneration()

        // THEN
        // ...
        // .X.
        // ...
        Assertions.assertEquals(linkedMapOf(
                Pair(0, 0) to Cell(CellState.DEAD),
                Pair(0, 1) to Cell(CellState.DEAD),
                Pair(0, 2) to Cell(CellState.DEAD),
                Pair(1, 0) to Cell(CellState.DEAD),
                Pair(1, 1) to Cell(),
                Pair(1, 2) to Cell(CellState.DEAD),
                Pair(2, 0) to Cell(CellState.DEAD),
                Pair(2, 1) to Cell(CellState.DEAD),
                Pair(2, 2) to Cell(CellState.DEAD)
        ), newGrid.getCells())
    }

    @Test
    fun `should generate next generation for a grid 2`() {
        // GIVEN
        // X..X.
        // .X.XX
        // ..XX.
        // XXXXX
        val cells: Cells = linkedMapOf(
                Pair(0, 0) to Cell(),
                Pair(0, 1) to Cell(CellState.DEAD),
                Pair(0, 2) to Cell(CellState.DEAD),
                Pair(0, 3) to Cell(),
                Pair(0, 4) to Cell(CellState.DEAD),

                Pair(1, 0) to Cell(CellState.DEAD),
                Pair(1, 1) to Cell(),
                Pair(1, 2) to Cell(CellState.DEAD),
                Pair(1, 3) to Cell(),
                Pair(1, 4) to Cell(),

                Pair(2, 0) to Cell(CellState.DEAD),
                Pair(2, 1) to Cell(CellState.DEAD),
                Pair(2, 2) to Cell(),
                Pair(2, 3) to Cell(),
                Pair(2, 4) to Cell(CellState.DEAD),

                Pair(3, 0) to Cell(),
                Pair(3, 1) to Cell(),
                Pair(3, 2) to Cell(),
                Pair(3, 3) to Cell(),
                Pair(3, 4) to Cell()
        )
        val grid = com.kata.gameoflife.domain.Grid(cells)

        // WHEN
        val newGrid = grid.nextGeneration()

        // THEN
        // ..XXX
        // .X..X
        // X....
        // .X..X
        Assertions.assertEquals(linkedMapOf(
                Pair(0, 0) to Cell(CellState.DEAD),
                Pair(0, 1) to Cell(CellState.DEAD),
                Pair(0, 2) to Cell(),
                Pair(0, 3) to Cell(),
                Pair(0, 4) to Cell(),

                Pair(1, 0) to Cell(CellState.DEAD),
                Pair(1, 1) to Cell(),
                Pair(1, 2) to Cell(CellState.DEAD),
                Pair(1, 3) to Cell(CellState.DEAD),
                Pair(1, 4) to Cell(),

                Pair(2, 0) to Cell(),
                Pair(2, 1) to Cell(CellState.DEAD),
                Pair(2, 2) to Cell(CellState.DEAD),
                Pair(2, 3) to Cell(CellState.DEAD),
                Pair(2, 4) to Cell(CellState.DEAD),

                Pair(3, 0) to Cell(CellState.DEAD),
                Pair(3, 1) to Cell(),
                Pair(3, 2) to Cell(CellState.DEAD),
                Pair(3, 3) to Cell(CellState.DEAD),
                Pair(3, 4) to Cell()
        ), newGrid.getCells())
    }
}
