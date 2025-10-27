package racingcar.support;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountInputParserTest {

    private final TryCountInputParser parser = new TryCountInputParser();

    @Test
    @DisplayName("정상적인 숫자 문자열을 정수로 변환한다")
    void 정상입력_파싱() {
        int result = parser.parse("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("입력이 null이면 예외가 발생한다")
    void 입력_null_예외() {
        assertThatThrownBy(() -> parser.parse(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }

    @Test
    @DisplayName("입력이 공백 문자열이면 예외가 발생한다")
    void 입력_공백_예외() {
        assertThatThrownBy(() -> parser.parse("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }

    @Test
    @DisplayName("입력이 숫자가 아닌 경우 예외가 발생한다")
    void 입력_비숫자_예외() {
        assertThatThrownBy(() -> parser.parse("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수");
    }

    @Test
    @DisplayName("입력에 공백이 있어도 trim 처리 후 정상 변환된다")
    void 입력_trim처리() {
        int result = parser.parse("   10   ");
        assertThat(result).isEqualTo(10);
    }
}
