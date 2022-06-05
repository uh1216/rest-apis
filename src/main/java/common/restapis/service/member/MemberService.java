package common.restapis.service.member;

import common.restapis.domain.member.Member;

public interface MemberService {

    Long join(Member member);

    Member findMember(Long id);
}
