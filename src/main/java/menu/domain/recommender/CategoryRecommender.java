package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;

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

    public MenuCategory recommendCategory() {
        int categoryIndex = Randoms.pickNumberInRange(1, 5);
        return CATEGORY_MAP.get(categoryIndex);
    }
}
