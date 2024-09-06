package hello.hello_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	// @Bean
	// public TimeTarceAop timeTarceAop() {
	// 	return new TimeTarceAop();
	// }

	// @Bean
	// public MemberRepository memberRepository() {
	// 	return new JpaMemberRepository(em);
	// }
}
