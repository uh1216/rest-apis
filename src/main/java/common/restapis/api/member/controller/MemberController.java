package common.restapis.api.member.controller;

import common.restapis.domain.member.service.MemberService;
import common.restapis.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/Members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public String saveMember(@Validated @ModelAttribute Member member, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult.getAllErrors());
            Optional<String> errorMessage = Optional.ofNullable(bindingResult.getFieldError().getDefaultMessage());
            return errorMessage.orElse("양식에 맞게 입력해주세요");
        }

        memberService.join(member);
        log.info("saved member={}", member.toString());
        return "회원가입 성공!";
    }

    @GetMapping("/findMember")
    public Member findMember(@RequestParam Long id) {
        return memberService.findMember(id);
    }

}
