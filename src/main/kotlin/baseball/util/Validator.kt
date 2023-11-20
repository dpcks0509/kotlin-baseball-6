package baseball.util

object Validator {
    fun validateAnswerNumbers(input: String): List<Int> {
        validateAnswerNumbersFormat(input)
        return input.map { it.digitToInt() }
    }

    private fun validateAnswerNumbersFormat(input: String) {
        requireNotNull(input.toIntOrNull()) { Exception.INVALID_ANSWER_NUMBERS_FORMAT.getErrorMessage() }
    }
}