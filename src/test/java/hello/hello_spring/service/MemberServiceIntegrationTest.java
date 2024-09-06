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
@Commit
public class MemberServiceIntegrationTest {

	String _name = "gkwon1";
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void join() {
		//gvien
		Member member = new Member();
		member.setName(_name);

		//when
		Long savedId = memberService.join(member);

		//then
		Member one = memberService.findOne(savedId).get();
		assertThat(member.getName()).isEqualTo(one.getName());
	}

	@Test
	public void duplicateJoin() {
		Member member1 = new Member();
		member1.setName(_name);
		Member member2 = new Member();
		member2.setName(_name);

		IllegalStateException e = assertThrows(IllegalStateException.class,
			() -> memberService.join(member2));

		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

	}
}
