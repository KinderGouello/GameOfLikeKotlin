package com.kata.gameoflife.domain

import kotlin.random.Random

class Game(width: Int, height: Int) {
    private val grid: Grid = Grid(generateRandomCells(width, height))

    private fun generateRandomCells(width: Int, height: Int): Cells {
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

    fun play(maxGenerations: Int = 0, output: canDisplay) {
        println("Game on!")
        output.displayGrid( 0, grid)
        var currentGrid: Grid = grid
        if (maxGenerations != 0) {
            for (generation in 1..maxGenerations) {
                val nextGenGrid = currentGrid.nextGeneration()
                output.displayGrid(generation, nextGenGrid)
                currentGrid = nextGenGrid
            }
            return
        }
        var generation = 0
        while (true) {
            val nextGenGrid = currentGrid.nextGeneration()
            output.displayGrid(generation, nextGenGrid)
            currentGrid = nextGenGrid
            generation += 1
        }
    }
}