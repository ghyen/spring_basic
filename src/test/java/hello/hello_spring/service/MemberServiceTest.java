package hello.hello_spring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemoryMemberRepository memoryMemberRepository;
	MemberService memberService;

	@BeforeEach
	public void beforeEach() {
		memoryMemberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memoryMemberRepository);
	}

	@AfterEach
	public void afterEach() {
		memoryMemberRepository.clear();
	}

	@Test
	public void join() {
		//gvien
		Member member = new Member();
		member.setName("gkwon");

		//when
		Long savedId = memberService.join(member);

		//then
		Member one = memberService.findOne(savedId).get();
		assertThat(member.getName()).isEqualTo(one.getName());
	}

	@Test
	public void duplicateJoin() {
		join();
		Member member = new Member();
		member.setName("gkwon");

		IllegalStateException e = assertThrows(IllegalStateException.class,
			() -> memberService.join(member));

		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// try {
		// 	memberService.join(member);
		// } catch (IllegalStateException e) {
		// 	assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// }

	}

	@Test
	void findMembers() {
	}

	@Test
	void findOne() {
	}
}
