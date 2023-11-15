package christmas;

import static java.lang.Integer.parseInt;

public class EventCalculateDiscounts extends EventModel {
    public EventCalculateDiscounts() {
        if (checkEventAvailable()) {
            calculateChristmasDiscount();
            isWeekEndsDiscount();
            calculateSpecialDiscount();
        }
        discounts = getGoodsDiscount() + getWeekDaysDiscount() + getChristmasDiscount() + getSpecialDiscount();
    }

    private static boolean checkEventAvailable() {
        if (getOrderPrice() >= 10000) {
            return true;
        }
        christmasDiscount = 0;
        return false;
    }

    private static void calculateChristmasDiscount() {
        if (getDate() <= 25) {
            christmasDiscount += (getDate() - 1) * 100;
            return;
        }
        christmasDiscount = 0;
    }

    private static void isWeekEndsDiscount() {
        if (getDate() % 7 == 1 || getDate() % 7 == 2) {
            calculateWeekDiscount(EventEnumCategories.MAIN);
            isWeekEnds = true;
            return;
        }
        calculateWeekDiscount(EventEnumCategories.DESSERT);
    }

    private static void calculateWeekDiscount(EventEnumCategories category) {
        for (String[] menu : orderedMenu) {
            if (category.getMenus().contains(EventEnumMenus.containingEnum(menu[0]))) {
                weekDaysDiscount += 2023 * parseInt(menu[1]);
            }
        }
    }

    private static void calculateSpecialDiscount() {
        if (getDate() % 7 == 3 || getDate() == 25) {
            specialDiscount += 1000;
        }
    }
}
