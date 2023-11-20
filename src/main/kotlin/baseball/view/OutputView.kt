package baseball.view

class OutputView {
    fun printGameStart() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printResult(result: Pair<Int, Int>) {
        when {
            result.second == 3 -> {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            }
            result.first == 0 && result.second == 0 -> println("낫싱")
            result.first != 0 && result.second != 0 -> println("${result.first}볼 ${result.second}스트라이크")
            result.first == 0 -> println("${result.second}스트라이크")
            result.second == 0 -> println("${result.first}볼")
        }
    }
}