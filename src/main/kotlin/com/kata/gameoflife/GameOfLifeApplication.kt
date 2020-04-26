package com.kata.gameoflife

import com.kata.gameoflife.domain.Game
import com.kata.gameoflife.infrastructure.ConsoleDisplay
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

@SpringBootApplication
class GameOfLifeApplication

fun main() {
	val reader = Scanner(System.`in`)
	print("Enter grid width: ")
	val width: Int = reader.nextInt()
	print("Enter grid height: ")
	val height: Int = reader.nextInt()
	print("Enter number of generation: ")
	val maxGenerations: Int = reader.nextInt()

	val game = Game(width, height)
	game.play(maxGenerations, ConsoleDisplay())
}
