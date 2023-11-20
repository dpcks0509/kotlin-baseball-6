package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val numbers = mutableListOf<Int>()

    init {
        setNumbers()
    }

    private fun setNumbers() {
        while (numbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
    }

    private fun resetNumbers() {
        numbers.clear()
    }

    fun getNumbers() = numbers
}