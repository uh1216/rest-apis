package common.restapis.api;

import common.restapis.domain.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/")
    public Member home(
            @SessionAttribute(name = "Login-Member", required = false) Member loginMember, Model model) {

        if (loginMember == null) {
            log.info("로그인 되지 않았습니다.");
            return null;
        }

        log.info("로그인 되었습니다.");
        log.info("안녕하세요 {}님",loginMember.getUserName());
        return loginMember;
    }
}
