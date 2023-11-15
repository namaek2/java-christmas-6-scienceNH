package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.EventEnumBadges.whichBadge;
import static christmas.EventEnumMenus.containingEnum;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class EnumTest extends NsTest {
    @Test
    void EventEnumMenu에서_containingEnum_테스트() {
        assertSimpleTest(() -> {
            assertThat(containingEnum("시저샐러드")).isEqualTo(EventEnumMenus.SALAD);
        });
    }

    @Test
    void EventEnumBadges에서_whichBadge_테스트() {
        assertSimpleTest(() -> {
            assertThat(whichBadge(18000)).isEqualTo("트리");
        });
        assertSimpleTest(() -> {
            assertThat(whichBadge(7000)).isEqualTo("별");
        });
        assertSimpleTest(() -> {
            assertThat(whichBadge(27000)).isEqualTo("산타");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
