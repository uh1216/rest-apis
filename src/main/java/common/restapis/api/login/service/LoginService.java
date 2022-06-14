package common.restapis.api.login.service;

import common.restapis.domain.member.domain.Member;
import common.restapis.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String userId, String password) { //ToDo 로그인시 Member객체 그대로를 반환하지 말고 로그인용 객체를 만들어야 한다.
        return memberRepository.findByUserId(userId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
