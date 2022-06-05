package common.restapis.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }
}
