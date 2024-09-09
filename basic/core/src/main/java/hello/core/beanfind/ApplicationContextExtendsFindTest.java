package hello.core.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("부모타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
	void findBeanByParentTypeDuplicate() {
		Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
			() -> ac.getBean(DiscountPolicy.class));
	}

	@Test
	@DisplayName("부모타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
	void findBeanByParentTypeBeanName() {
		NoUniqueBeanDefinitionException rateDiscountPolicy = ac.getBean("rateDiscountPolicy",
			NoUniqueBeanDefinitionException.class);
	}

	@Configuration
	static class TestConfig {
		@Bean
		public DiscountPolicy reateDiscountPolicy() {
			return new RateDiscountPolicy();
		}
		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
	}
}
