package christmas;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;

public class EventModel {
    private static int date;
    static ArrayList<String[]> orderedMenu = new ArrayList<>();
    static int leftMenus = 20;
    static int orderPrice = 0;
    static int christmasDiscount = 1000;
    static int weekDaysDiscount = 0;
    static int specialDiscount = 0;
    static int goodsDiscount = 0;
    static boolean isWeekEnds = false;
    static int discounts = 0;

    public static void setOrderedMenu(String[] menuInfo) {
        orderedMenu.add(menuInfo);
        leftMenus -= parseInt(menuInfo[1]);
    }

    public static ArrayList<String[]> getOrderedMenu() {
        return orderedMenu;
    }

    public static int getLeftMenus() {
        return leftMenus;
    }


    public static void setDate(int num) {
        date = num;
    }

    public static int getDate() {
        return date;
    }

    public static int getOrderPrice() {
        return orderPrice;
    }

    public static EventEnumMenus containingEnum(String menu) {
        for (EventEnumMenus eventEnumMenus : EventEnumMenus.values()) {
            if (eventEnumMenus.getName().equals(menu)) {
                return eventEnumMenus;
            }
        }

        return null;
    }

    public static int getChristmasDiscount() {
        return christmasDiscount;
    }

    public static int getWeekDaysDiscount() {
        return weekDaysDiscount;
    }

    public static int getSpecialDiscount() {
        return specialDiscount;
    }

    public static int getGoodsDiscount() {
        return goodsDiscount;
    }

    public static boolean getIsWeekEnds() {
        return isWeekEnds;
    }

    public static int getDiscounts() {
        return discounts;
    }

    public static void eraseOrderedMenu() {
        orderedMenu.clear();
        leftMenus = 20;
    }

    public static void calculateOrderPrice() {
        for (String[] menu : orderedMenu) {
            orderPrice += containingEnum(menu[0]).getPrice() * parseInt(menu[1]);
        }
    }

    public static void shampaignEvent(int orderPrice) {
        if (orderPrice >= 120000) {
            EventView.printShampaignEvent(true);
            goodsDiscount = 25000;
            return;
        }
        EventView.printShampaignEvent(false);
    }

    public static void caculateDiscounts() {
        if (checkEventAvailable()) {
            calculateChristmasDiscount();
            calculateWeekDiscount();
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

    private static void calculateWeekDiscount() {
        if (getDate() % 7 == 1 || getDate() % 7 == 2) {
            calculateWeekEndsDiscount(EventEnumCategories.MAIN);
            isWeekEnds = true;
            return;
        }
        calculateWeekEndsDiscount(EventEnumCategories.DESSERT);
    }

    private static void calculateWeekEndsDiscount(EventEnumCategories category) {
        for (String[] menu : orderedMenu) {
            if (category.getMenus().contains(EventModel.containingEnum(menu[0]))) {
                weekDaysDiscount += 2023 * parseInt(menu[1]);
            }
        }
    }

    private static void calculateSpecialDiscount() {
        if (getDate() % 7 == 3 || getDate() == 25) {
            specialDiscount += 1000;
        }
    }

    public static String calculateBadges(int discounts) {
        for (EventEnumBadges eventEnumBadge : EventEnumBadges.values()) {
            if (eventEnumBadge.getPrice() <= discounts) {
                return eventEnumBadge.getName();
            }
        }
        return ("없음");
    }
}
