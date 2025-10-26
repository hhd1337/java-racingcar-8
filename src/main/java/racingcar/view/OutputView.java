package racingcar.view;

public class OutputView {
    public void printCarNameNotice() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void printTryCountNotice() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void printRaceStartHeader() {
        System.out.println("실행 결과");
    }
    // 차수별 실행결과 출력
    public void printRoundResult(String name, int distance) {
        System.out.println(name + " : ");
        for (int i = 1; i <= distance; i++) {
            System.out.println("-");
        }
    }
    public void printWinners(String names) {
        System.out.println("최종 우승자 : " + names);
    }
}
