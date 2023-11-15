package christmas;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;

public class EventCalculateDiscounts extends EventModel {
    public EventCalculateDiscounts() {
        if (checkEventAvailable(getOrderPrice())) {
            calculateChristmasDiscount(getDate());
            isWeekEndsDiscount(getDate(), getOrderedMenu());
            calculateSpecialDiscount(getDate());
        }
        discounts = getGoodsDiscount() + getWeekDaysDiscount() + getChristmasDiscount() + getSpecialDiscount();
    }

    public static boolean checkEventAvailable(int price) {
        if (price >= 10000) {
            return true;
        }
        christmasDiscount = 0;
        return false;
    }

    public static void calculateChristmasDiscount(int date) {
        if (date <= 25) {
            christmasDiscount += (date - 1) * 100;
            return;
        }
        christmasDiscount = 0;
    }

    public static void isWeekEndsDiscount(int date, ArrayList<String[]> menus) {
        if (date % 7 == 1 || date % 7 == 2) {
            calculateWeekDiscount(EventEnumCategories.MAIN, menus);
            isWeekEnds = true;
            return;
        }
        calculateWeekDiscount(EventEnumCategories.DESSERT, menus);
    }

    public static void calculateWeekDiscount(EventEnumCategories category, ArrayList<String[]> menus) {
        for (String[] menu : menus) {
            if (category.getMenus().contains(EventEnumMenus.containingEnum(menu[0]))) {
                weekDaysDiscount += 2023 * parseInt(menu[1]);
            }
        }
    }

    public static void calculateSpecialDiscount(int date) {
        if (date % 7 == 3 || date == 25) {
            specialDiscount += 1000;
        }
    }
}
