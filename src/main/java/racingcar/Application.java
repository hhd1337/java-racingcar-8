package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printCarNameNotice();
        String carNames = inputView.readLine();
        // TODO : 자동차 이름 입력값 검증

        outputView.printTryCountNotice();
        int tryCount = Integer.parseInt(inputView.readLine());
        // TODO : 시도할 횟수 입력값 검증

        // TODO : 실행결과 출력, 최종우승자 출력
    }
}
