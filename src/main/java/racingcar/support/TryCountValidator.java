package racingcar.support;

public class TryCountValidator {

    public static final int MAX_TRY_COUNT = 100;

    public void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }else if(value > MAX_TRY_COUNT){
            throw new IllegalArgumentException("시도할 횟수는 " + MAX_TRY_COUNT + "이하여야 합니다.");
        }
    }

}
