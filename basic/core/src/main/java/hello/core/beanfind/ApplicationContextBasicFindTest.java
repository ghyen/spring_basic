package hello.core.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.MemberApp;
import hello.core.member.MemberService;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println(memberService);
	}

	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByNameX() {
		Assertions.assertThrows(NoSuchBeanDefinitionException.class,
			() -> ac.getBean("xxxx", MemberService.class));
	}

	@Test
	@DisplayName("빈 타입으로 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		System.out.println(memberService);
	}
}
