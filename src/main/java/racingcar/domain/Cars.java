package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public void moveCars() {
        // TODO : move strategy에 따라 cars를 순회하며 car.move()하는 로직 작성
    }

    public List<Car> getCars(){
        return cars;
    }

}
