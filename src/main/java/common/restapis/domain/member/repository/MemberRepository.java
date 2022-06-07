package common.restapis.domain.member.repository;

import common.restapis.domain.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long id);

    Optional<Member> findByUserId(String Userid);

    List<Member> findAll();
}
