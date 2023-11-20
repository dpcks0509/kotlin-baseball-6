package baseball.view

import baseball.util.Validator.validateAnswerNumbers
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readAnswerNumbers(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        return validateAnswerNumbers(input)
    }
}