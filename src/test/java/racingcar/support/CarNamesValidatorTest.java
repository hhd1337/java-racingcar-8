package racingcar.support;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesValidatorTest {

    private final CarNamesValidator validator = new CarNamesValidator();

    @Test
    @DisplayName("정상 입력 시 예외가 발생하지 않는다")
    void 정상입력_검증() {
        List<String> names = List.of("pobi", "hhd", "wj");
        validator.validate(names);
    }

    @Test
    @DisplayName("이름 리스트가 비어 있으면 예외 발생")
    void 이름리스트_비어있음_예외() {
        assertThatThrownBy(() -> validator.validate(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }

    @Test
    @DisplayName("이름이 null 또는 공백이면 예외 발생")
    void 이름_null_공백_예외() {
        List<String> names = List.of("pobi", "", "hhd");
        assertThatThrownBy(() -> validator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외 발생")
    void 이름길이_초과_예외() {
        List<String> names = List.of("pobi", "longname");
        assertThatThrownBy(() -> validator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    @DisplayName("이름이 중복되면 예외 발생")
    void 중복이름_예외() {
        List<String> names = List.of("pobi", "hhd", "pobi");
        assertThatThrownBy(() -> validator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("자동차 수가 1대 이하이면 예외 발생")
    void 최소_자동차수_예외() {
        List<String> names = List.of("pobi");
        assertThatThrownBy(() -> validator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2대");
    }
}
