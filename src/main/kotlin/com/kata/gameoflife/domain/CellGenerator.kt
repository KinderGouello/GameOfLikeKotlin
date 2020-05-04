package com.kata.gameoflife.domain

import kotlin.random.Random

object CellGenerator {
    fun generateRandomCells(width: Int, height: Int): Cells {
        val cells: Cells = linkedMapOf();
        for (x in 0 until width) {
            for (y in 0 until height) {
                val random = Random.nextInt(0, 100)
                if (random > 50) {
                    cells[Pair(x, y)] = Cell()
                    continue
                }
                cells[Pair(x, y)] = Cell(CellState.DEAD)
            }
        }
        return cells
    }
}