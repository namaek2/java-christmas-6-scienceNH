package christmas;

public enum EventEnumBadges {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);


    private final String NAME;
    private final int PRICE;

    EventEnumBadges(String NAME, int PRICE) {
        this.NAME = NAME;
        this.PRICE = PRICE;
    }

    public String getName() {
        return NAME;
    }

    public int getPrice() {
        return PRICE;
    }
}
