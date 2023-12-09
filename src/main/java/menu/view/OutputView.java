package menu.view;

import menu.domain.Coach;
import menu.domain.Menu;

import java.util.List;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static void startRecommendation() {
        System.out.println("점심 메뉴 추천을 시작합니다." + LINE_SEPARATOR);
    }

    public static void endRecommendation() {
        System.out.println("추천을 완료했습니다.");
    }

    public static void printResults(List<Coach> coaches, List<Menu> weeklyCategories) {
        System.out.println("메뉴 추천 결과입니다.");

        printHeaderRow(weeklyCategories);

        for (Coach coach : coaches) {
            System.out.printf("[ %s | %s ]%n", coach.getName(), getMenuRecommendationString(coach));
        }

        System.out.println();
    }

    private static void printHeaderRow(List<Menu> weeklyCategories) {
        System.out.print("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]" + LINE_SEPARATOR);
        System.out.print("[ 카테고리 | ");
        int lastIndex = weeklyCategories.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            System.out.printf("%s | ", weeklyCategories.get(i).getName());
        }
        if (lastIndex >= 0) {
            System.out.printf("%s", weeklyCategories.get(lastIndex).getName());
        }
        System.out.println(" ]");
    }

    private static String getMenuRecommendationString(Coach coach) {
        StringBuilder sb = new StringBuilder();
        Menu[] menus = Menu.values();
        for (int i = 0; i < menus.length - 1; i++) {
            String recommendedMenu = coach.getRecommendedMenu(i);
            sb.append(recommendedMenu);
            sb.append(" | ");
        }
        sb.append(coach.getRecommendedMenu(menus.length - 1));
        return sb.toString();
    }
}
