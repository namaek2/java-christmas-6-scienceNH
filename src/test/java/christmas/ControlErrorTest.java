package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ControlErrorTest extends NsTest {

    @Test
    void 날짜_예외_범위_테스트() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 입력한 날짜는 1 이상 31 이하의 양수여야 합니다.");
        });
    }

    @Test
    void 메뉴_입력_형식_테스트() {
        assertSimpleTest(() -> {
            runException("31", "타파스:1,제로콜라:1");
            assertThat(output()).contains("[ERROR] 입력한 메뉴의 형식이 잘못되었습니다.");
        });
    }

    @Test
    void 메뉴_개수_0_테스트() {
        assertSimpleTest(() -> {
            runException("3", "타파스-0");
            assertThat(output()).contains("[ERROR] 입력한 메뉴의 개수는 1 이상의 양수여야 합니다.");
        });
    }

    @Test
    void 메뉴_개수_20이상_테스트() {
        assertSimpleTest(() -> {
            runException("3", "타파스-22");
            assertThat(output()).contains("[ERROR] 주문한 메뉴의 개수는 총 20개 이하여야 합니다.");
        });
    }

    @Test
    void 메뉴_입력_존재_테스트() {
        assertSimpleTest(() -> {
            runException("3", "뚝배기-1");
            assertThat(output()).contains("[ERROR] 입력한 메뉴는 존재하지 않습니다.");
        });
    }

    @Test
    void 메뉴_입력_중복_테스트() {
        assertSimpleTest(() -> {
            runException("3", "바비큐립-1,티본스테이크-2,바비큐립-2");
            assertThat(output()).contains("[ERROR] 입력한 메뉴는 중복됩니다.");
        });
    }

    @Test
    void 메뉴_음료만_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-3");
            assertThat(output()).contains("[ERROR] 음료만 주문할 수 없습니다.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
