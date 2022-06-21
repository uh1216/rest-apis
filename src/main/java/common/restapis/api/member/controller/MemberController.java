package common.restapis.api.member.controller;

import common.restapis.api.messages.ErrorMessage;
import common.restapis.api.messages.SuccessMessage;
import common.restapis.domain.member.service.MemberService;
import common.restapis.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/Members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public SuccessMessage saveMember(@Validated @RequestBody Member member, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult.getAllErrors());
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }

        memberService.join(member);
        log.info("saved member={}", member.toString());
        return new SuccessMessage(HttpStatus.OK,"회원가입 성공!", member);
    }

}
