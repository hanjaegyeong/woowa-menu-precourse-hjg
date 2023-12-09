package menu.domain;

import java.util.Set;

public class Coach {
    private String name;
    private Set<String> restrictedMenus;

    public Coach(String name, Set<String> restrictedMenus) {
        this.name = name;
        this.restrictedMenus = restrictedMenus;
    }
}