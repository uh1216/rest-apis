package common.restapis.domain.member.service;

import common.restapis.domain.member.domain.Member;

public interface MemberService {

    Long join(Member member);

    Member findMember(Long id);
}
