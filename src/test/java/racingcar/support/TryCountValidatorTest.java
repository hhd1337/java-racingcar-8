package racingcar.support;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountValidatorTest {

    private final TryCountValidator validator = new TryCountValidator();

    @Test
    @DisplayName("정상 범위 내 값이면 예외가 발생하지 않는다")
    void 정상입력_검증성공() {
        validator.validate(10); // 아무 예외 없음
    }

    @Test
    @DisplayName("시도 횟수가 0 이하이면 예외 발생")
    void 시도횟수_0이하_예외() {
        assertThatThrownBy(() -> validator.validate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    @DisplayName("시도 횟수가 음수이면 예외 발생")
    void 시도횟수_음수_예외() {
        assertThatThrownBy(() -> validator.validate(-5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    @DisplayName("시도 횟수가 100 초과이면 예외 발생")
    void 시도횟수_최댓값_초과_예외() {
        assertThatThrownBy(() -> validator.validate(TryCountValidator.MAX_TRY_COUNT + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이하여야");
    }
    
}
