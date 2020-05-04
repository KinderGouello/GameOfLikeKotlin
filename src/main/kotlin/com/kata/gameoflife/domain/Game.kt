package com.kata.gameoflife.domain

class Game(width: Int, height: Int) {
    private val grid: Grid = Grid(CellGenerator.generateRandomCells(width, height))

    fun play(maxGenerations: Int = 0, output: canDisplay) {
        println("Game on!")
        var currentGrid: Grid = grid
        var generation = 0
        do {
            output.displayGrid(generation, grid)
            currentGrid = currentGrid.nextGeneration()
            generation += 1
        } while (stop(maxGenerations, generation))
    }

    private fun stop(maxGenerations: Int, currentGeneration: Int): Boolean {
        if (maxGenerations == 0) return true
        return currentGeneration <= maxGenerations
    }
}