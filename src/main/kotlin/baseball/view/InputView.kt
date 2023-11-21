package baseball.view

import baseball.util.Validator.validateAnswerNumbers
import baseball.util.Validator.validateGameDecision
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readAnswerNumbers(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        return validateAnswerNumbers(input)
    }

    fun readGameDecision(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = Console.readLine()
        return validateGameDecision(input)
    }
}