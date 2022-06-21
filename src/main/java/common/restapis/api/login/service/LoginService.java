package common.restapis.api.login.service;

import common.restapis.domain.member.domain.LoginMember;
import common.restapis.domain.member.domain.Member;
import common.restapis.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginMember login(String userId, String password) {
        Member member = memberRepository.findByUserId(userId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);

        if (member == null) {
            throw new RuntimeException("아이디 또는 비밀번호가 맞지 않습니다.");
        }

        LoginMember loginMember = new LoginMember();
        loginMember.setUserName(member.getUserName());

        return loginMember;
    }
}
