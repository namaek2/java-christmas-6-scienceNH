package christmas;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;

public class EventModel {
    private static int date;
    static ArrayList<String[]> orderedMenu = new ArrayList<>();
    static int leftMenus = 20;
    static int orderPrice = 0;


    public static EventEnumMenus containingEnum(String menu) {
        for (EventEnumMenus eventEnumMenus : EventEnumMenus.values()) {
            if (eventEnumMenus.getName().equals(menu)) {
                return eventEnumMenus;
            }
        }

        return null;
    }

    public static void eraseOrderedMenu() {
        orderedMenu.clear();
        leftMenus = 20;
    }

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

    public static void setOrderPrice(int num) {
        orderPrice = num;
    }

    public static int getOrderPrice() {
        return orderPrice;
    }
}
