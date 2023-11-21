package baseball.model

import baseball.util.Constants.NUMBER_COUNT

class BaseballGame {
    private var ball = 0
    private var strike = 0
    private var isGameInProgress = true

    private fun resetGameStats() {
        ball = 0
        strike = 0
        isGameInProgress = true
    }

    fun getResult(randomNumbers: List<Int>, answerNumbers: List<Int>): Pair<Int, Int> {
        resetGameStats()
        for (i in 0 until NUMBER_COUNT) {
            if (randomNumbers[i] == answerNumbers[i]) strike += 1
            else if (randomNumbers.contains(answerNumbers[i])) ball += 1
        }
        if (strike == 3) isGameInProgress = false
        return Pair(ball, strike)
    }

    fun isGameInProgress() = isGameInProgress
}