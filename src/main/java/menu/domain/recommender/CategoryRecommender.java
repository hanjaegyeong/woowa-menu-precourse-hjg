package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CategoryRecommender {
    private static final Map<Integer, MenuCategory> CATEGORY_MAP = new HashMap<>();

    static {
        CATEGORY_MAP.put(1, MenuCategory.JAPANESE);
        CATEGORY_MAP.put(2, MenuCategory.KOREAN);
        CATEGORY_MAP.put(3, MenuCategory.CHINESE);
        CATEGORY_MAP.put(4, MenuCategory.ASIAN);
        CATEGORY_MAP.put(5, MenuCategory.WESTERN);
    }

    public List<MenuCategory> recommendWeeklyCategories() {
        List<MenuCategory> weeklyCategories = new ArrayList<>();
        Map<MenuCategory, Integer> categoryCount = new HashMap<>();

        while (weeklyCategories.size() < 5) {
            MenuCategory category = recommendCategory();
            categoryCount.putIfAbsent(category, 0);

            if (categoryCount.get(category) < 2) {
                categoryCount.put(category, categoryCount.get(category) + 1);
                weeklyCategories.add(category);
            }
        }

        return weeklyCategories;
    }

    public MenuCategory recommendCategory() {
        int categoryIndex = Randoms.pickNumberInRange(1, 5);
        return CATEGORY_MAP.get(categoryIndex);
    }
}
