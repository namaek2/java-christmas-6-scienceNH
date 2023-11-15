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

    public static void shampaignEvent(int orderPrice) {
        if (orderPrice >= 120000) {
            EventView.printShampaignEvent(true);
            goodsDiscount = 25000;
            return;
        }
        EventView.printShampaignEvent(false);
    }

    public static void calculateOrderPrice() {
        for (String[] menu : orderedMenu) {
            orderPrice += EventEnumMenus.containingEnum(menu[0]).getPrice() * parseInt(menu[1]);
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
