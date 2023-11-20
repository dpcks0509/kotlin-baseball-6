package baseball.controller

import baseball.model.Computer
import baseball.model.GamePlayer
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printGameStart()
        val computer = Computer()
        val gamePlayer = GamePlayer(inputView.readAnswerNumbers())
    }
}