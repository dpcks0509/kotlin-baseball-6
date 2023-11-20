package baseball.model

import baseball.util.Exception

class GamePlayer(private val answerNumbers: List<Int>) {
    init {
        require(answerNumbers.size == 3) { Exception.INVALID_ANSWER_NUMBERS_SIZE.getErrorMessage() }
        require(!answerNumbers.contains(0)) { Exception.INVALID_ANSWER_NUMBERS_CONTAINS_ZERO.getErrorMessage() }
        require(answerNumbers.toSet().size == 3) { Exception.INVALID_ANSWER_NUMBERS_DUPLICATE_NUMBERS.getErrorMessage() }
    }

    fun getAnswerNumbers() = answerNumbers
}