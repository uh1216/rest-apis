package common.restapis.domain.member.service;

import common.restapis.domain.member.domain.Member;
import common.restapis.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String join(Member member) {
        isUserIdDuplicate(member);
        memberRepository.save(member);
        return "회원가입 성공!";

    }

    private void isUserIdDuplicate(Member member) {
        if (memberRepository.findByUserId(member.getUserId()).isPresent()) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }
    }

    @Override
    public Member findMember(String userId) {
        return memberRepository.findByUserId(userId).orElse(null);
    }
}
