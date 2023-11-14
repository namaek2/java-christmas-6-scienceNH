package christmas;

import static java.lang.Integer.parseInt;
import camp.nextstep.edu.missionutils.Console;

public class EventControl {
    private final int DATE;
    EventControl() {
        EventView.firstScreen();
        DATE = inputDate();
    }

    public static int inputDate() {
        String date = Console.readLine();
        while(catchDateError(date)) {
            EventView.tryAgainMessage();
            date = Console.readLine();
        }

        return parseInt(date);
    }

    public static boolean catchDateError(String date) {
        try {
            EventControlError.checkDateError(date);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
