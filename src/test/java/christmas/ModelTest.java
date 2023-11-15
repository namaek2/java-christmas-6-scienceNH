package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.EventModel.calculateOrderPrice;
import static christmas.EventModel.getOrderPrice;
import static christmas.EventModel.isShampaignEvent;
import static christmas.EventModel.setOrderPrice;
import static christmas.EventModel.setOrderedMenu;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ModelTest extends NsTest {
    @Test
    void 샴페인_증정_여부_테스트() {
        assertSimpleTest(() -> {
            assertThat(isShampaignEvent(260000)).isTrue();
        });
        assertSimpleTest(() -> {
            assertThat(isShampaignEvent(9000)).isFalse();
        });
    }

    @Test
    void 총_주문_가격_테스트() {
        assertSimpleTest(() -> {
            setOrderPrice(0);
            ArrayList<String[]> menus = new ArrayList<>();
            menus.add(new String[]{"크리스마스파스타", "2"});
            menus.add(new String[]{"샴페인", "1"});
            menus.add(new String[]{"아이스크림", "1"});
            menus.add(new String[]{"제로콜라", "1"});
            calculateOrderPrice(menus);
            assertThat(getOrderPrice()).isEqualTo(83000);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
