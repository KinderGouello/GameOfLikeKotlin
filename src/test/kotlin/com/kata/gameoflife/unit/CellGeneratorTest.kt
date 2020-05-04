package com.kata.gameoflife.unit

import com.kata.gameoflife.domain.Cell
import com.kata.gameoflife.domain.CellGenerator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CellGeneratorTest {
    @Test
    fun `returns a random set of cells`() {
        val width = 10
        val height = 10
        val cells = CellGenerator.generateRandomCells(width, height)

        assertSame(width * height, cells.size)
        assertTrue(cells[Pair(0, 0)] is Cell)
    }
}
