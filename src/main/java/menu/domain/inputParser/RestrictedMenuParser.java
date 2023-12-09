package menu.domain.inputParser;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;

public class RestrictedMenuParser {
    public static final int MAX_RESTRICTED_MENUS = 2;
    public static final String ERROR_MAX_RESTRICTED_MENUS = "각 코치는 최대 " + MAX_RESTRICTED_MENUS + "개의 못 먹는 메뉴만 입력할 수 있습니다.";

    public Set<String> parseMenus(String input) {
        if (input.trim().isEmpty()) {
            return Set.of();
        }

        Set<String> menus = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(menu -> !menu.isEmpty())
                .collect(Collectors.toSet());

        validateMenus(menus);
        return menus;
    }

    private void validateMenus(Set<String> menus) {
        if (menus.size() > MAX_RESTRICTED_MENUS) {
            throw new IllegalArgumentException(ERROR_MAX_RESTRICTED_MENUS);
        }
    }
}