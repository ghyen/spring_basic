package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

	@Test
	@DisplayName("싱글톤 테스트")
	public void singletoneServiceTest() {
		SingletonService s1 = SingletonService.getInstance();
		SingletonService s2 = SingletonService.getInstance();

		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
	}
}
