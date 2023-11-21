package baseball.model

import baseball.util.Constants.NUMBER_COUNT
import baseball.util.Constants.NUMBER_END
import baseball.util.Constants.NUMBER_START
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val randomNumbers = mutableListOf<Int>()

    fun setRandomNumbers() {
        randomNumbers.clear()
        while (randomNumbers.size < NUMBER_COUNT) {
            val randomNumber = Randoms.pickNumberInRange(NUMBER_START, NUMBER_END)
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber)
            }
        }
    }

    fun getRandomNumbers() = randomNumbers
}