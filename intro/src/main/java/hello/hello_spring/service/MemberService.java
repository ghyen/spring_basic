package hello.hello_spring.service;

import java.util.List;
import java.util.Optional;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import jakarta.transaction.Transactional;

@Transactional
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// 회원가입
	public Long join(Member member) {
		// 중복이름 확인
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}

	// 전체 회원 조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
