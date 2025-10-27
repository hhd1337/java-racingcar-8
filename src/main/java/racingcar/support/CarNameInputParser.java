package racingcar.support;

import java.util.ArrayList;
import java.util.List;

public class CarNameInputParser {

    private static final String NAME_SEPARATOR = ",";

    public List<String> parseCarNames(String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 입력이 비어 있습니다.");
        }

        List<String> carNames = new ArrayList<>();
        String[] parsedNames = input.split(NAME_SEPARATOR);

        for (int i = 0; i < parsedNames.length; i++) {
            carNames.add(parsedNames[i].trim());
        }

        return carNames;
    }
}
