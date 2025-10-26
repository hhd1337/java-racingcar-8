package racingcar.domain.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    public static final int MOVE_THRESHOLD_NUM = 4; // 임계값(기준값)

    @Override
    public boolean isMovable() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= MOVE_THRESHOLD_NUM;
    }
}
