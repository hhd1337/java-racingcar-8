package racingcar;

import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 자동차 이름 입력
        outputView.printCarNameNotice();
        String carNames = inputView.readLine();

        // TODO : 자동차 이름 입력 문자열 검증, 파싱
        // TODO : Car 인스턴스 모두 생성
        // TODO : Cars 인스턴스 생성

        // 시도할 횟수 입력
        outputView.printTryCountNotice();
        int tryCount = Integer.parseInt(inputView.readLine());

        // TODO : 시도할 횟수 입력값 검증



        // TODO : 실행결과 출력, 최종우승자 출력
    }
}
