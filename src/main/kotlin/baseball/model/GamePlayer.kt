package baseball.model

class GamePlayer() {
    private var answerNumbers = listOf<Int>()

    fun setAnswerNumbers(input: List<Int>) {
        answerNumbers = input
    }

    fun getAnswerNumbers() = answerNumbers
}