package common.restapis.api.login.controller;

import common.restapis.api.login.service.LoginService;
import common.restapis.api.messages.SuccessMessage;
import common.restapis.api.session.SessionConst;
import common.restapis.domain.member.domain.LoginMember;
import common.restapis.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login") //ToDo bindingResult 값 틀렸을 때 다시 입력 값 넘겨주기(검증 완성 후)
    public SuccessMessage login(@RequestBody Member member, BindingResult bindingResult, HttpServletRequest request) {
        LoginMember loginMember = loginService.login(member.getUserId(), member.getPassword());

        log.info("로그인 성공");
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return new SuccessMessage(HttpStatus.OK, "로그인 성공", loginMember);
    }

    @GetMapping("/logout")
    public SuccessMessage logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        log.info("로그아웃 되었습니다.");
        return new SuccessMessage(HttpStatus.OK, "로그아웃 되었습니다.");
    }

}
