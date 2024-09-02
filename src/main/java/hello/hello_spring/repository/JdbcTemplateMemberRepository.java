package hello.hello_spring.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hello.hello_spring.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcTemplateMemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Member save(Member member) {
		return null;
	}

	@Override
	public Optional<Member> findById(Long memberId) {
		List<Member> query = jdbcTemplate.query("select * from member where id = ?", memberRowMapper());
		return query.stream().findAny();
	}

	@Override
	public Optional<Member> findByName(String name) {
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return null;
	}

	private RowMapper<Member> memberRowMapper() {
		return (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setName("name");
			return member;
		};
	}
}
