package baseball

import baseball.util.Validator.validateAnswerNumbers
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballTest {
    @ParameterizedTest
    @ValueSource(strings = ["123", "456", "789"])
    fun `올바른 정답 입력`(input: String) {
        assertDoesNotThrow { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one23", "123 ", " 123"])
    fun `정답 입력 예외처리 (숫자가 아닌 값을 입력하거나 공백이 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "12 ", " 1234"])
    fun `정답 입력 예외처리 (숫자의 길이가 3이 아니다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["012", "102 ", " 120"])
    fun `정답 입력 예외처리 (숫자 0이 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["112", "122 ", " 212"])
    fun `정답 입력 예외처리 (중복되는 숫자가 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }
}