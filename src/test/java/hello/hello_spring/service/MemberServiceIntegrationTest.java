package hello.hello_spring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	@Commit
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

	}
}
