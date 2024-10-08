package hello.core.beanfind;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	// @Test
	// @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류")
	// void findBeanByTypeDuplicate() {
	// 	Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
	// 		() -> ac.getBean(MemberRepository.class));
	// }
	//
	// @Test
	// @DisplayName("특정 타입 모두 조회하기")
	// void findAllBeanByType() {
	// 	Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
	//
	// 	for (String key : beansOfType.keySet()) {
	// 		System.out.println("key = " + key + "val = " + beansOfType.get(key));
	// 	}
	// 	System.out.println("beansOfType = " + beansOfType);
	// }
	//
	// @Configuration
	// static class SameBeanConfig {
	// 	@Bean
	// 	public MemberRepository memberRepository1() {
	// 		return new MemoryMemberRepository();
	// 	}
	//
	// 	@Bean
	// 	public MemberRepository memberRepository2() {
	// 		return new MemoryMemberRepository();
	// 	}
	// }

}
