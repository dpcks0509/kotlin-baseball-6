package baseball.model

import baseball.util.Constants.NUMBER_COUNT
import baseball.util.Constants.NUMBER_END
import baseball.util.Constants.NUMBER_START
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var numbers = mutableListOf<Int>()

    init {
        setNumbers()
    }

    private fun setNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(NUMBER_START,NUMBER_END,NUMBER_COUNT)
    }

    private fun resetNumbers() {
        numbers.clear()
    }

    fun getNumbers() = numbers
}