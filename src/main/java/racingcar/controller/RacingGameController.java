package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.RandomMoveStrategy;
import racingcar.support.CarNameInputParser;
import racingcar.support.CarNamesValidator;
import racingcar.support.TryCountInputParser;
import racingcar.support.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameInputParser carNameInputParser;
    private final TryCountInputParser tryCountInputParser;
    private final CarNamesValidator carNamesValidator;
    private final TryCountValidator tryCountValidator;
    private final MoveStrategy moveStrategy;

    public RacingGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        carNameInputParser = new CarNameInputParser();
        tryCountInputParser = new TryCountInputParser();
        carNamesValidator = new CarNamesValidator();
        tryCountValidator = new TryCountValidator();
        moveStrategy = new RandomMoveStrategy();
    }

    public void run() {
        // 자동차 이름 입력
        outputView.printCarNameNotice();
        String carNamesInput = inputView.readLine();

        // 입력 파싱, 검증
        List<String> carNamesList = carNameInputParser.parseCarNames(carNamesInput); // 파싱
        carNamesValidator.validate(carNamesList); // 검증, 예외처리

        // car 생성 및 리스트에 add
        List<Car> carList = new ArrayList<>();
        for (String name : carNamesList) {
            carList.add(new Car(name));
        }
        // cars 생성
        Cars cars = new Cars(carList);

        // 시도할 횟수 입력
        outputView.printTryCountNotice();
        String tryCountRaw = inputView.readLine();

        // 시도할 횟수 입력값 검증
        int tryCount = tryCountInputParser.parse(tryCountRaw);
        tryCountValidator.validate(tryCount);

        // 실행결과 출력
        outputView.printRaceStartHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(moveStrategy);
            outputView.printRoundResult(cars);
        }

        // 최종우승자 출력
        outputView.printWinners(cars);
    }
}
