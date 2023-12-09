package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static String inputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        String coachName = readLine();
        System.out.print(LINE_SEPARATOR);

        return coachName;
    }

    public static String inputMenuRestrictions(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");

        String restrictedMenuNames = readLine();
        System.out.print(LINE_SEPARATOR);

        return restrictedMenuNames;
    }
}