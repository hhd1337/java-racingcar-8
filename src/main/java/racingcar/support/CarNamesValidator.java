package racingcar.support;

import java.util.List;

public class CarNamesValidator {

    public void validate(List<String> carNames) {
        validateEmptyList(carNames);
        validateEmptyName(carNames);
        validateLength(carNames);
        validateSameName(carNames);
        validateMinCars(carNames);
    }

    private void validateEmptyList(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
    }

    private void validateEmptyName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
        }
    }

    private void validateLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 입력해야 합니다.");
            }
        }
    }

    private void validateSameName(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            for (int j = i + 1; j < carNames.size(); j++) { // 자기자신 이후의 이름들만 중복검사
                if (carNames.get(i).equals(carNames.get(j))) {
                    throw new IllegalArgumentException("자동차 이름이 중복 입력되었습니다.");
                }
            }
        }
    }

    private void validateMinCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대 입력해야 합니다.");
        }
    }

}
