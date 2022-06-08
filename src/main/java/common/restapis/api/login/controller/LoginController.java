package common.restapis.api.login.controller;

import common.restapis.api.login.service.LoginService;
import common.restapis.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Member login(@ModelAttribute Member member, BindingResult bindingResult, HttpServletRequest request) { //ToDo bindingResult 값 틀렸을 때 다시 입력 값 넘겨주기(검증 완성 후)
        Member memberLogin = loginService.login(member.getUserId(), member.getPassword());
        if (memberLogin == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return null;
        }

        log.info("로그인 성공");

        HttpSession session = request.getSession();
        session.setAttribute("Login-Member", memberLogin);

        return memberLogin;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            log.info("로그아웃 되었습니다.");
        }
    }

}
