package common.restapis.api;

import common.restapis.api.messages.ErrorMessage;
import common.restapis.api.messages.Message;
import common.restapis.api.messages.SuccessMessage;
import common.restapis.domain.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/")
    public Message home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        log.info("안녕하세요 {}님",loginMember.getUserName());
        return new SuccessMessage(HttpStatus.OK, String.format("안녕하세요 %s님", loginMember.getUserName()));
    }
}
