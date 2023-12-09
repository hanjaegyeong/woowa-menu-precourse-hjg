package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CategoryRecommender {
    private static final Map<Integer, Menu> CATEGORY_MAP = new HashMap<>();

    static {
        CATEGORY_MAP.put(1, Menu.JAPANESE);
        CATEGORY_MAP.put(2, Menu.KOREAN);
        CATEGORY_MAP.put(3, Menu.CHINESE);
        CATEGORY_MAP.put(4, Menu.ASIAN);
        CATEGORY_MAP.put(5, Menu.WESTERN);
    }

    public List<Menu> recommendWeeklyCategories() {
        List<Menu> weeklyCategories = new ArrayList<>();
        Map<Menu, Integer> categoryCount = new HashMap<>();

        while (weeklyCategories.size() < 5) {
            Menu category = recommendCategory();
            categoryCount.putIfAbsent(category, 0);

            if (categoryCount.get(category) < 2) {
                categoryCount.put(category, categoryCount.get(category) + 1);
                weeklyCategories.add(category);
            }
        }

        return weeklyCategories;
    }

    public Menu recommendCategory() {
        int categoryIndex = Randoms.pickNumberInRange(1, 5);
        return CATEGORY_MAP.get(categoryIndex);
    }
}
