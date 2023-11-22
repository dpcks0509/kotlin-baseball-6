package baseball

import baseball.model.BaseballGame
import baseball.model.Computer
import baseball.util.Constants.THREE_STRIKE
import baseball.util.Validator.validateAnswerNumbers
import baseball.util.Validator.validateGameDecision
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballTest {
    @ParameterizedTest
    @ValueSource(strings = ["123", "456", "789"])
    fun `올바른 게임 플레이어 정답 입력`(input: String) {
        assertDoesNotThrow { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one23", "123 ", " 123"])
    fun `게임 플레이어 정답 입력 예외처리 (숫자가 아닌 값을 입력하거나 공백이 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "12 ", " 1234"])
    fun `게임 플레이어 정답 입력 예외처리 (숫자의 길이가 3이 아니다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["012", "102 ", " 120"])
    fun `게임 플레이어 정답 입력 예외처리 (숫자 0이 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["112", "122 ", " 212"])
    fun `게임 플레이어 정답 입력 예외처리 (중복되는 숫자가 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `올바른 게임 재시작 여부 입력`(input: String) {
        assertDoesNotThrow { validateGameDecision(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one", "two", " 1", " 2 "])
    fun `게임 재시작 여부 입력 예외처리 (숫자가 아닌 값을 입력하거나 공백이 존재한다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0 ", " 3"])
    fun `게임 재시작 여부 입력 예외처리 (1과 2 중 하나의 수가 아니다)`(input: String) {
        assertThrows<IllegalArgumentException> { validateAnswerNumbers(input) }
    }

    @Test
    fun `컴퓨터 랜덤 숫자 생성 3자리 확인`() {
        val computer = Computer()

        computer.setRandomNumbers()

        assertThat(computer.getRandomNumbers().size == 3)
    }

    @Test
    fun `컴퓨터 랜덤 숫자 생성 숫자 범위 확인`() {
        val computer = Computer()

        computer.setRandomNumbers()
        println(computer.getRandomNumbers())

        assertTrue(computer.getRandomNumbers().all { it in 1..9 })
    }

    @Test
    fun `컴퓨터 랜덤 숫자 생성 중복 확인`() {
        val computer = Computer()

        computer.setRandomNumbers()

        assertThat(computer.getRandomNumbers().toSet().size == 3)
    }

    @Test
    fun `정답 결과 판단 확인 (3스트라이크)`() {
        val baseballGame = BaseballGame()
        val expectResult = THREE_STRIKE

        val actualResult = baseballGame.getResult(listOf(1, 2, 3), listOf(1, 2, 3))

        assertThat(actualResult).isEqualTo(expectResult)
    }

    @Test
    fun `정답 결과 판단 확인 (낫싱)`() {
        val baseballGame = BaseballGame()
        val expectResult = "낫싱"

        val actualResult = baseballGame.getResult(listOf(1, 2, 3), listOf(4, 5, 6))

        assertThat(actualResult).isEqualTo(expectResult)
    }

    @Test
    fun `정답 결과 판단 확인 (볼, 스트라이크)`() {
        val baseballGame = BaseballGame()
        val expectResult = "2볼 1스트라이크"

        val actualResult = baseballGame.getResult(listOf(1, 2, 3), listOf(1, 3, 2))

        assertThat(actualResult).isEqualTo(expectResult)
    }

    @Test
    fun `정답 결과 판단 확인 (스트라이크)`() {
        val baseballGame = BaseballGame()
        val expectResult = "2스트라이크"

        val actualResult = baseballGame.getResult(listOf(1, 2, 3), listOf(1, 2, 5))

        assertThat(actualResult).isEqualTo(expectResult)
    }

    @Test
    fun `정답 결과 판단 확인 (볼)`() {
        val baseballGame = BaseballGame()
        val expectResult = "1볼"

        val actualResult = baseballGame.getResult(listOf(1, 2, 3), listOf(4, 5, 1))

        assertThat(actualResult).isEqualTo(expectResult)
    }
}