package hello.hello_spring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;

public class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();
	Member member1;
	Member member2;

	@BeforeEach
	public void init() {
		member1 = new Member();
		member1.setName("gkwon");

		member2 = new Member();
		member2.setName("edwin");
	}

	@Test
	public void save() {
		repository.save(member1);

		Member result = repository.findById(member1.getId()).get();
		assertThat(member1).isEqualTo(result);
	}

	@Test
	public void findByName() {
		repository.save(member2);
		String findName = "edwin";

		Member result = repository.findByName(findName).get();
		assertThat(member2).isEqualTo(result);
	}

	@Test
	public void findAll() {
		repository.save(member1);
		repository.save(member2);

		List<Member> result = repository.findAll();

		assertThat(result.size()).isEqualTo(2);
	}
}
