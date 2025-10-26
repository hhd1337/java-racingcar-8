package racingcar.support;

public class TryCountInputParser {
    public int parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("시도할 횟수 입력이 비어 있습니다.");
        }

        String trimmed = input.trim();
        if (trimmed.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수 입력이 비어 있습니다.");
        }

        try {
            return Integer.parseInt(trimmed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
    }
}
