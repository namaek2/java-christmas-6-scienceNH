package christmas;

import static java.lang.Integer.parseInt;

public class EventControlError {
    public static void checkDateError(String date) {
        if (!date.chars().allMatch(Character::isDigit)) {
            System.out.println("[ERROR] 입력한 날짜는 양수의 정수여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 입력한 날짜는 양수의 정수여야 합니다.");
        } else if (parseInt(date) < 1 || parseInt(date) > 31) {
            System.out.println("[ERROR] 입력한 날짜는 1 이상 31 이하의 양수여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 입력한 날짜는 1 이상 31 이하의 양수여야 합니다.");
        }
    }
}
