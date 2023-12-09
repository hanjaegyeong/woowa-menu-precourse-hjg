package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Coach {
    private String name;
    private Set<String> restrictedMenus;
    private List<String> recommendedMenus;

    public Coach(String name, Set<String> restrictedMenus) {
        this.name = name;
        this.restrictedMenus = restrictedMenus;
        this.recommendedMenus = new ArrayList<>();
    }

    public static Coach createCoach(String name, String restrictedMenuString) {
        Set<String> restrictedMenus = Arrays.stream(restrictedMenuString.split(","))
                .filter(menu -> !menu.isEmpty())
                .collect(Collectors.toSet());
        return new Coach(name, restrictedMenus);
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }
}