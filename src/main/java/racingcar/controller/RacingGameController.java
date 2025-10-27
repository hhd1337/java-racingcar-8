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
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carNameInputParser = new CarNameInputParser();
        this.tryCountInputParser = new TryCountInputParser();
        this.carNamesValidator = new CarNamesValidator();
        this.tryCountValidator = new TryCountValidator();
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void run() {
        Cars cars = setupCars();
        int tryCount = requestTryCount();

        startRace(cars, tryCount);
        showWinners(cars);
    }

    private Cars setupCars() {
        outputView.printCarNameNotice();
        String raw = inputView.readLine();

        List<String> names = parseAndValidateCarNames(raw);
        List<Car> carList = buildCars(names);
        return new Cars(carList);
    }

    private int requestTryCount() {
        outputView.printTryCountNotice();
        String raw = inputView.readLine();

        int tryCount = tryCountInputParser.parse(raw);
        tryCountValidator.validate(tryCount);
        return tryCount;
    }

    private void startRace(Cars cars, int tryCount) {
        outputView.printRaceStartHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(moveStrategy);
            outputView.printRoundResult(cars);
        }
    }

    private void showWinners(Cars cars) {
        outputView.printWinners(cars);
    }

    private List<String> parseAndValidateCarNames(String raw) {
        List<String> names = carNameInputParser.parseCarNames(raw);
        carNamesValidator.validate(names);
        return names;
    }

    private List<Car> buildCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
