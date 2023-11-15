package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.EventCalculateDiscounts.calculateChristmasDiscount;
import static christmas.EventCalculateDiscounts.calculateSpecialDiscount;
import static christmas.EventCalculateDiscounts.checkEventAvailable;
import static christmas.EventCalculateDiscounts.isWeekEndsDiscount;
import static christmas.EventModel.getChristmasDiscount;
import static christmas.EventModel.getSpecialDiscount;
import static christmas.EventModel.getWeekDaysDiscount;
import static christmas.EventModel.setChristmasDiscount;
import static christmas.EventModel.setSpecialDiscount;
import static christmas.EventModel.setWeekDaysDiscount;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class CalculateDiscountsTest extends NsTest {
    @Test
    void 이벤트_조건_부합_테스트() {
        assertThat(checkEventAvailable(12000)).isTrue();
        assertThat(checkEventAvailable(9900)).isFalse();
    }

    @Test
    void 크리스마스_디데이_혜택_테스트() {
        assertSimpleTest(() -> {
            setChristmasDiscount(1000);
            calculateChristmasDiscount(25);
            assertThat(getChristmasDiscount()).isEqualTo(3400);
            setChristmasDiscount(1000);
            calculateChristmasDiscount(20);
            assertThat(getChristmasDiscount()).isEqualTo(2900);
        });
    }

    @Test
    void 평일_주말_혜택_테스트() {
        assertSimpleTest(() -> {
            ArrayList<String[]> menus = new ArrayList<>();
            menus.add(new String[]{"초코케이크", "2"});
            menus.add(new String[]{"티본스테이크", "1"});
            setWeekDaysDiscount(0);
            isWeekEndsDiscount(1, menus);
            assertThat(getWeekDaysDiscount()).isEqualTo(2023);
            setWeekDaysDiscount(0);
            isWeekEndsDiscount(3, menus);
            assertThat(getWeekDaysDiscount()).isEqualTo(4046);
        });
    }

    @Test
    void 특별_혜택_테스트() {
        assertSimpleTest(() -> {
            setSpecialDiscount(0);
            calculateSpecialDiscount(24);
            assertThat(getSpecialDiscount()).isEqualTo(1000);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
