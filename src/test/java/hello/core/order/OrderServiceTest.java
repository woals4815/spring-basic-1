package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        //이건 순수 자바코드로 테스트 한 것이기에 각자의 메모리 주소가 다 다른 new 객체이다.
        System.out.println("hello");
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        System.out.println("hello");
        orderService = appConfig.orderService();
        System.out.println("hello");
    }

    @Test()
    public void createOrder() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        assertThat(order.calculatePrice()).isEqualTo(9000);
    }

}
