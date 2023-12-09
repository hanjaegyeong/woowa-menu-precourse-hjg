package menu.view;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static void startRecommendation() {
        System.out.println("점심 메뉴 추천을 시작합니다." + LINE_SEPARATOR);
    }

    public static void endRecommendation() {
        System.out.println("추천을 완료했습니다.");
    }
}