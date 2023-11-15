package christmas;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class EventControl {
    EventControl() {
        EventView.firstScreen();
        inputDate();
        inputMenu();
        controlOrderedPrice();
        controlShampaignEvent();
        controlDiscounts();
        EventView.printFinalFee();
        controlBadge();
    }

    public void inputDate() {
        String date = Console.readLine();

        while (catchDateError(date)) {
            EventView.tryAgainMessage();
            date = Console.readLine();
        }

        EventModel.setDate(parseInt(date));
    }

    private boolean catchDateError(String date) {
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

        EventView.printOrderedMenu();
    }

    private boolean catchMenuError(String menu) {
        try {
            EventControlError.checkMenuError(menu);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public void controlOrderedPrice() {
        EventModel.calculateOrderPrice(EventModel.getOrderedMenu());
        EventView.printOrderPrice();
    }

    public void controlShampaignEvent() {
        boolean isShampaignTrue = EventModel.isShampaignEvent(EventModel.getOrderPrice());
        EventView.printShampaignEvent(isShampaignTrue);
    }

    public void controlDiscounts() {
        new EventCalculateDiscounts();
        EventView.printDiscounts(EventModel.getDiscounts());
        EventView.printTotalDiscounts();
    }

    public void controlBadge() {
        String badge = EventEnumBadges.whichBadge(EventModel.getDiscounts());
        EventView.printBadge(badge);
    }
}
