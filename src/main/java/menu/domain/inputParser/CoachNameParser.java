package menu.domain.inputParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachNameParser {
    public List<String> parseNames(String input) {
        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        validateNames(names);
        return names;
    }

    private void validateNames(List<String> names) {
        validateNumberOfCoaches(names);
        validateNameLengths(names);
    }


    private void validateNumberOfCoaches(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명 이상, 최대 5명까지만 입력 가능합니다.");
        }
    }

    private void validateNameLengths(List<String> names) {
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException("각 코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
            }
        }
    }
}
