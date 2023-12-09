package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MenuRecommender {
    private static final Map<MenuCategory, List<String>> MENUS = new HashMap<>();

    static {
        MENUS.put(MenuCategory.JAPANESE, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        MENUS.put(MenuCategory.KOREAN, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        MENUS.put(MenuCategory.CHINESE, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        MENUS.put(MenuCategory.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        MENUS.put(MenuCategory.WESTERN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public String recommendMenu(MenuCategory category) {
        List<String> menus = MENUS.get(category);
        return Randoms.shuffle(menus).get(0);
    }
}
