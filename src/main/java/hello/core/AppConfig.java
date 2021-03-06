package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 1. @Bean MemberService ->  new MemoryMemberRepository()
    // 2. @Bean OrderService ->  new MemoryMemberRepository()
    // 배운 것을 바탕으로 하면 계속해서 생성해서 주입하기 때문에 singleton이 깨진 것이다.

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");

        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        return memoryMemberRepository;
    }

    @Bean
    public OrderService orderService() {

        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
        return new FixDiscountPolicy();
    }
}
