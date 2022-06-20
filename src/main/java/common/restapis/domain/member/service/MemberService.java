package common.restapis.domain.member.service;

import common.restapis.domain.member.domain.Member;

public interface MemberService {

    String join(Member member);

    Member findMember(String userId);
}
