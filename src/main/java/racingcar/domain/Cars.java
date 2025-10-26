package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.move.MoveStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }
    // 1회 경주 시도 시 moveStrategy에 따라 각 car의 position++ 하는 메소드
    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            if (moveStrategy.isMovable()){
                car.move();
            }
        }
    }

    public int finalMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public List<String> getWinnerNames() {
        int max = finalMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars(){
        return cars;
    }

}
