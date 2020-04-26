package com.kata.gameoflife.infrastructure

import com.kata.gameoflife.domain.Grid
import com.kata.gameoflife.domain.canDisplay

class ConsoleDisplay: canDisplay {

    override fun displayGrid(generation: Int, grid: Grid) {
        val output = grid.getCells().asIterable().fold("Generation $generation:\n") {
            lines, (position, cell) ->
            val newLine = if (position.first != 0 && position.second == 0) "\n" else ""
            val cellState = if (cell.isAlive()) "*" else "."
            lines + "$newLine$cellState"
        }
        println(output)
    }
}