package baseball.util

enum class Exception(private val message: String) {
    INVALID_FORMAT("숫자가 아닌 값을 입력하거나 공백이 존재한다."),
    INVALID_ANSWER_NUMBERS_SIZE("숫자의 길이가 3이 아니다."),
    INVALID_ANSWER_NUMBERS_CONTAINS_ZERO("숫자 0이 존재한다."),
    INVALID_ANSWER_NUMBERS_DUPLICATED("중복되는 숫자가 존재한다."),
    INVALID_GAME_DECISION_RANGE("재시작/종료를 구분하는 1과 2 중 하나의 수를 입력한다.");

    fun getErrorMessage() = "[ERROR] $message"
}