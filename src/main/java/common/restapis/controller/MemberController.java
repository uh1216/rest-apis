package common.restapis.controller;

import common.restapis.domain.member.Member;
import common.restapis.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/Members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Member saveMember(@ModelAttribute Member member) {
        memberService.join(member);
        log.info("saved member={}", member.toString());
        return member;
    }

}
