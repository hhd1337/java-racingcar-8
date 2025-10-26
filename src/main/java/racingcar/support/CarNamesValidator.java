package racingcar.support;

import java.util.List;

public class CarNamesValidator {

    public void validate (List<String> carNames){
        validateEmptyList(carNames); // 리스트 자체 비었는지
        validateEmptyName(carNames); // 각 이름 null/blank 아닌지
        validateLength(carNames); // 각 이름 5자 초과 아닌지
        validateSameName(carNames); // 중복된 이름 없는지
        validateMinCars(carNames); // 자동차 2대이상 입력했는지
    }

    // 빈 리스트 (CarNameInputParser 이후 안전하게 한번 더 확인)
    private void validateEmptyList (List<String> carNames){
        if (carNames == null || carNames.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
    }

    // 자동차 이름이 ""이거나 공백만 있는 경우
    private void validateEmptyName (List<String> carNames){
        for (String carName : carNames){
            if (carName == null || carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
        }
    }

    // 5자 초과 입력 시
    private void validateLength (List<String> carNames){
        for (String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 입력해야 합니다.");
            }
        }
    }

    // 중복이름
    private void validateSameName (List<String> carNames){
        for (int i=0; i<carNames.size(); i++){
            for (int j = i+1; j < carNames.size(); j++){ // 자기자신 이후의 이름들만 중복검사
                if (carNames.get(i).equals(carNames.get(j))){
                    throw new IllegalArgumentException("자동차 이름이 중복 입력되었습니다.");
                }
            }
        }
    }

    // 자동차 1대만 입력한 경우
    private void validateMinCars (List<String> carNames){
        if (carNames.size() < 2){
            throw new IllegalArgumentException("자동차는 최소 2대 입력해야 합니다.");
        }
    }

}
