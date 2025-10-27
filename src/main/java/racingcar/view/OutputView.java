package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public void printCarNameNotice() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountNotice() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceStartHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        List<String> winners = cars.getWinnerNames();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
