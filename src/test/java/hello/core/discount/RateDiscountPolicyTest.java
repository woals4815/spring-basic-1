package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP must get 10% discount")
    void vip_o() {
        Member member = new Member(1L, "memberVip", Grade.VIP);
        int discountPrice = discountPolicy.discount(member, 12009);
        assertThat(discountPrice).isEqualTo(1200);
    }

    @Test
    @DisplayName("BASIC must not get 10% discount")
    void vip_x() {
        Member member = new Member(1L, "memberVip", Grade.BASIC);
        int discountPrice = discountPolicy.discount(member, 12009);
        assertThat(discountPrice).isEqualTo(00);
    }
}