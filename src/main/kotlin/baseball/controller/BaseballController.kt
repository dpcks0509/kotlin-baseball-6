package baseball.controller

import baseball.model.BaseballGame
import baseball.model.Computer
import baseball.model.GamePlayer
import baseball.util.Constants.GAME_START
import baseball.util.Constants.NO_ANSWER
import baseball.util.Constants.THREE_STRIKE
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private val computer = Computer()
    private val gamePlayer = GamePlayer()
    private val baseballGame = BaseballGame()
    private var gameDecision = GAME_START

    fun run() {
        displayGameStartMessage()
        while (isGameOnGoing()) {
            if (isNewGame()) setUpNewGame()
            getPlayerAnswer()
            provideHint()
            if (isGameEnded()) askRestartOrEnd()
        }
    }

    private fun displayGameStartMessage() {
        outputView.printGameStart()
    }

    private fun isNewGame(): Boolean {
        return gameDecision == GAME_START
    }

    private fun isGameOnGoing(): Boolean {
        return gameDecision == GAME_START || gameDecision == NO_ANSWER
    }

    private fun setUpNewGame() {
        computer.setRandomNumbers()
    }

    private fun getPlayerAnswer() {
        val answer = inputView.readAnswerNumbers()
        gamePlayer.setAnswerNumbers(answer)
    }

    private fun provideHint() {
        val hint = baseballGame.getResult(computer.getRandomNumbers(), gamePlayer.getAnswerNumbers())
        checkAnswer(hint)
        outputView.printResult(hint)
    }

    private fun checkAnswer(hint: String) {
        if (hint != THREE_STRIKE) gameDecision = NO_ANSWER
    }

    private fun isGameEnded(): Boolean {
        return !baseballGame.isGameInProgress()
    }

    private fun askRestartOrEnd() {
        gameDecision = inputView.readGameDecision()
    }
}