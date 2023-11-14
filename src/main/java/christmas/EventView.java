package christmas;

public class EventView {
    public static void firstScreen() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void tryAgainMessage() {
        System.out.println("다시 입력하세요.");
    }

    public static void orgerGuideMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printOrderedMenu() {
        System.out.println("12월 " + EventModel.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        for (String[] menu : EventModel.getOrderedMenu()) {
            System.out.println(menu[0] + " " + menu[1] + "개");
        }
    }
}
