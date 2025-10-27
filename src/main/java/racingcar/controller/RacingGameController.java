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
        outputView.printCarNameNotice();
        String carNamesInput = inputView.readLine();

        List<String> carNamesList = carNameInputParser.parseCarNames(carNamesInput);
        carNamesValidator.validate(carNamesList);

        List<Car> carList = new ArrayList<>();
        for (String name : carNamesList) {
            carList.add(new Car(name));
        }

        Cars cars = new Cars(carList);

        outputView.printTryCountNotice();
        String tryCountRaw = inputView.readLine();

        int tryCount = tryCountInputParser.parse(tryCountRaw);
        tryCountValidator.validate(tryCount);

        outputView.printRaceStartHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(moveStrategy);
            outputView.printRoundResult(cars);
        }

        outputView.printWinners(cars);
    }
}
