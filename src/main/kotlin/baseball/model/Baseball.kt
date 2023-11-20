package baseball.model

import baseball.util.Constants.NUMBER_COUNT

class Baseball {
    private var ball = 0
    private var strike = 0

    fun judgeResult(computerNumbers: List<Int>, answerNumbers: List<Int>): Pair<Int, Int> {
        for (i in 0 until NUMBER_COUNT) {
            if (computerNumbers[i] == answerNumbers[i]) strike += 1
            else if (computerNumbers.contains(answerNumbers[i])) ball += 1
        }
        return Pair(ball, strike)
    }
}