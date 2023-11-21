package baseball.util

import baseball.util.Constants.GAME_END
import baseball.util.Constants.GAME_START

object Validator {
    fun validateAnswerNumbers(input: String): List<Int> {
        validateAnswerNumbersFormat(input)
        validateAnswerNumbersSize(input)
        validateAnswerNumberContainsZero(input)
        validateAnswerNumberDuplicated(input)
        return input.map { it.digitToInt() }
    }

    private fun validateAnswerNumbersFormat(input: String) {
        requireNotNull(input.toIntOrNull()) { Exception.INVALID_FORMAT.getErrorMessage() }
    }

    private fun validateAnswerNumbersSize(input: String) {
        require(input.length == 3) { Exception.INVALID_ANSWER_NUMBERS_SIZE.getErrorMessage() }
    }

    private fun validateAnswerNumberContainsZero(input: String) {
        require(!input.contains("0")) { Exception.INVALID_ANSWER_NUMBERS_CONTAINS_ZERO.getErrorMessage() }
    }

    private fun validateAnswerNumberDuplicated(input: String) {
        require(input.toSet().size == 3) { Exception.INVALID_ANSWER_NUMBERS_DUPLICATED.getErrorMessage() }
    }

    fun validateGameDecision(input: String): Int {
        validateGameDecisionFormat(input)
        validateGameDecisionRange(input)
        return input.toInt()
    }

    private fun validateGameDecisionFormat(input: String) {
        requireNotNull(input.toIntOrNull()) { Exception.INVALID_FORMAT.getErrorMessage() }
    }

    private fun validateGameDecisionRange(input: String) {
        require(input.toInt() in GAME_START..GAME_END) { Exception.INVALID_GAME_DECISION_RANGE.getErrorMessage() }
    }
}