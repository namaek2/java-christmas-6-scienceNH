package christmas;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class EventControl {
    EventControl() {
        EventView.firstScreen();
        EventModel.setDate(inputDate());
        inputMenu();
        EventView.printOrderedMenu();
        EventModel.calculateOrderPrice();
        EventView.printOrderPrice();
        EventModel.shampaignEvent(EventModel.getOrderPrice());
        new EventCalculateDiscounts();
        EventView.printDiscounts(EventModel.getDiscounts());
        EventView.printTotalDiscounts();
        EventView.printFinalFee();
        EventView.printBadge(EventModel.calculateBadges(EventModel.getDiscounts()));
    }

    public int inputDate() {
        String date = Console.readLine();

        while (catchDateError(date)) {
            EventView.tryAgainMessage();
            date = Console.readLine();
        }

        return parseInt(date);
    }

    public boolean catchDateError(String date) {
        try {
            EventControlError.checkDateError(date);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public void inputMenu() {
        EventView.orgerGuideMessage();

        String menu = Console.readLine();
        while (catchMenuError(menu)) {
            EventModel.eraseOrderedMenu();
            EventView.tryAgainMessage();
            menu = Console.readLine();
        }
    }

    public boolean catchMenuError(String menu) {
        try {
            EventControlError.checkMenuError(menu);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
