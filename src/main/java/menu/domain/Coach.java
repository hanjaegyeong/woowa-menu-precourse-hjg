package menu.domain;

import java.util.*;

public class Coach {
    private final String name;
    private final Set<String> restrictedMenus;
    private final List<String> recommendedMenus;

    public Coach(String name, Set<String> restrictedMenus) {
        this.name = name;
        this.restrictedMenus = restrictedMenus;
        this.recommendedMenus = new ArrayList<>();
    }

    public boolean canAddMenu(String menu) {
        return !restrictedMenus.contains(menu) && !recommendedMenus.contains(menu);
    }

    public void addMenu(String menu) {
        recommendedMenus.add(menu);
    }

    public String getRecommendedMenu(int index) {
        return recommendedMenus.get(index);
    }

    public String getName() {
        return name;
    }
}