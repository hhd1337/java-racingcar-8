package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 생성자 인자로 설정된다")
    void 자동차_이름_세팅() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("move() 호출 시 position이 1 증가한다")
    void 이동하면_위치_증가() {
        Car car = new Car("pobi");
        int before = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(before + 1);
    }
}
