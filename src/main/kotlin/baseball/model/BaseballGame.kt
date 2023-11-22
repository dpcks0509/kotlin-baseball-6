package baseball.model

import baseball.util.Constants.NUMBER_COUNT
import baseball.util.Constants.THREE_STRIKE

class BaseballGame {
    private var ball = 0
    private var strike = 0
    private var isGameInProgress = true

    private fun resetGameStats() {
        ball = 0
        strike = 0
        isGameInProgress = true
    }

    fun getResult(randomNumbers: List<Int>, answerNumbers: List<Int>): String {
        resetGameStats()
        for (i in 0 until NUMBER_COUNT) {
            if (randomNumbers[i] == answerNumbers[i]) strike += 1
            else if (randomNumbers.contains(answerNumbers[i])) ball += 1
        }
        if (strike == 3) {
            isGameInProgress = false
            return THREE_STRIKE
        }
        if (ball == 0 && strike == 0) return "낫싱"
        if (ball != 0 && strike != 0) return "${ball}볼 ${strike}스트라이크"
        if (ball == 0) return "${strike}스트라이크"
        return "${ball}볼"
    }

    fun isGameInProgress() = isGameInProgress
}