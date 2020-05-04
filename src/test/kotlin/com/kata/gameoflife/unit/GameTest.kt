package com.kata.gameoflife.unit

import com.kata.gameoflife.domain.Game
import com.kata.gameoflife.domain.canDisplay
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class GameTest {
    @Test
    fun `plays the game`() {
        val width = 10
        val height = 10
        val outputMock = Mockito.spy(canDisplay::class.java)

        val game = Game(width, height)
        game.play(4, outputMock)

        val invocations = Mockito.mockingDetails(outputMock).invocations
        assertSame(5, invocations.size)
    }
}