package spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.service.MemberService;
import spring.web.dto.MemberDto;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/membersignup")
    public void membersignup(MemberDto memberDto){
        memberService.membersave(memberDto);
    }
    @PostMapping("/membersignup")
    public void membersignup_c(MemberDto memberDto){
        memberService.membersave(memberDto);
    }

}
