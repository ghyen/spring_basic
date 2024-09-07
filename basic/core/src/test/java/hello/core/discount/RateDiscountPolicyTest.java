package hello.core.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP should discount 10%")
	void vip_o() {

		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);

		//when
		int discount = discountPolicy.discount(member, 10000);

		//then
		assertThat(discount).isEqualTo(1000);
	}

	@Test
	@DisplayName("not VIP should not discount 10%")
	void vip_x() {

		//given
		Member member = new Member(1L, "memberVIP", Grade.BASIC);

		//when
		int discount = discountPolicy.discount(member, 10000);

		//then
		assertThat(discount).isEqualTo(0);
	}
}
