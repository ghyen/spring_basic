package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import hello.core.member.MemberRepository;

@SpringBootTest
class CoreApplicationTests {

	@Test
	void contextLoads() throws Exception {
		run();
	}

	@Autowired
	private ApplicationContext ctx;

	public void run(String... args) throws Exception {
		String[] beanNames = ctx.getBeanNamesForType(MemberRepository.class);
		for (String beanName : beanNames) {
			System.out.println("Bean name: " + beanName);
		}
	}

}
