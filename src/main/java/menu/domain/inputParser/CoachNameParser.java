package menu.domain.inputParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachNameParser {
    public static final int MIN_COACHES = 2;
    public static final int MAX_COACHES = 5;
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 4;

    public static final String ERROR_MIN_MAX_COACHES = "[ERROR] 코치는 최소 " + MIN_COACHES + "명 이상, 최대 " + MAX_COACHES + "명까지만 입력 가능합니다.";
    public static final String ERROR_NAME_LENGTH = "[ERROR] 각 코치의 이름은 최소 " + MIN_NAME_LENGTH + "글자, 최대 " + MAX_NAME_LENGTH + "글자여야 합니다.";

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
        if (names.size() < MIN_COACHES || names.size() > MAX_COACHES) {
            throw new IllegalArgumentException(ERROR_MIN_MAX_COACHES);
        }
    }

    private void validateNameLengths(List<String> names) {
        for (String name : names) {
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }
}
