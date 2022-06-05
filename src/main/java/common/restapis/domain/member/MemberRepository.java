package common.restapis.domain.member;

import common.restapis.domain.member.Member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long id);

    List<Member> findAll();
}
