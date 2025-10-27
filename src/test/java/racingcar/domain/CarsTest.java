package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.MoveStrategy;


public class CarsTest {

    // 항상 전진,정지하는 테스트 스텁
    static class AlwaysMove implements MoveStrategy {
        @Override
        public boolean isMovable() {
            return true;
        }
    }

    static class NeverMove implements MoveStrategy {
        @Override
        public boolean isMovable() {
            return false;
        }
    }

    @Test
    @DisplayName("항상 전진인 MoveStrategy일 때, 모든 차가 1 전진한다")
    void 항상_전진전략_모든자동차_전진() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b")));
        cars.moveCars(new AlwaysMove());

        assertThat(cars.getCars()).allSatisfy(c ->
                assertThat(c.getPosition()).isEqualTo(1));
    }

    @Test
    @DisplayName("항상 전진 불가인 MoveStrategy일 때, 모든 차가 정지한다")
    void 항상_전진불가전략_모든자동차_정지() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b")));
        cars.moveCars(new NeverMove());

        assertThat(cars.getCars()).allSatisfy(c ->
                assertThat(c.getPosition()).isEqualTo(0));
    }

    @Test
    @DisplayName("최대 위치값을 반환한다")
    void 최종_최대_위치() {
        Car a = new Car("a");
        a.move();
        Car b = new Car("b");
        b.move();
        b.move();
        Car c = new Car("c");

        Cars cars = new Cars(List.of(a, b, c));

        assertThat(cars.finalMaxPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("단독 우승자를 반환한다")
    void 단독_우승자() {
        Car a = new Car("a");
        a.move();
        Car b = new Car("b");
        b.move();
        b.move();
        Car c = new Car("c");

        Cars cars = new Cars(List.of(a, b, c));

        assertThat(cars.getWinnerNames())
                .containsExactly("b");
    }

    @Test
    @DisplayName("공동 우승자를 반환한다")
    void 공동_우승자() {
        Car a = new Car("a");
        a.move();
        a.move();
        Car b = new Car("b");
        b.move();
        b.move();
        Car c = new Car("c");

        Cars cars = new Cars(List.of(a, b, c));

        assertThat(cars.getWinnerNames())
                .containsExactlyInAnyOrder("a", "b");
    }
}
