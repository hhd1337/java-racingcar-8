package racingcar.support;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameInputParserTest {

    private final CarNameInputParser parser = new CarNameInputParser();

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름을 올바르게 파싱한다")
    void 정상입력_파싱() {
        String input = "pobi, hhd, wj";

        List<String> result = parser.parseCarNames(input);

        assertThat(result).containsExactly("pobi", "hhd", "wj");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되어도 trim 처리된다")
    void 공백제거_파싱() {
        String input = "  pobi , hhd ,   wj ";

        List<String> result = parser.parseCarNames(input);

        assertThat(result).containsExactly("pobi", "hhd", "wj");
    }

    @Test
    @DisplayName("입력이 null이면 예외가 발생한다")
    void 입력_null_예외() {
        assertThatThrownBy(() -> parser.parseCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }

    @Test
    @DisplayName("입력이 공백 문자열이면 예외가 발생한다")
    void 입력_공백_예외() {
        assertThatThrownBy(() -> parser.parseCarNames("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }
}
