package spring.web;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.service.MemberService;
import spring.web.dto.MemberDto;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/membersignup")
    public String membersignup(MemberDto memberDto){
        return "/membersignup";
    }
    @PostMapping("/membersignup")
    public String membersignup_c(MemberDto memberDto){
        memberService.membersave(memberDto);
        return "redirect:/memberlogin";
    }

    @GetMapping("/memberlogin")
    public String memberlogin(){
        return "memberlogin";
    }
    @PostMapping("/memberlogin")
    public String memberlogin_c(MemberDto loginDto){

        MemberDto memberDto = memberService.memberlogin(loginDto);

        if(memberDto!=null){
            session.setAttribute("loginuser",memberDto);
            return "redirect:/";
        }else{
            return "redirect:/memberlogin";
        }

    }

    @GetMapping("/memberinfo")
    public String memberinfo(Model model){
        MemberDto temp = (MemberDto) session.getAttribute("loginuser");
        MemberDto memberDto = memberService.memberfind(temp.getId());
        model.addAttribute("memberDto",memberDto);
        return "memberinfo";
    }

    @GetMapping("/memberlogout")
    public String memberlogout(){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/memberdelete")
    public String memberdelete(){
        MemberDto memberDto = (MemberDto) session.getAttribute("loginuser");
        Long id = memberDto.getId();
        int result = memberService.memberdelete(id);
        if(result == 1){
            session.invalidate();
            return "redirect:/";
        }else{
            return "redirect:/";
        }

    }
    @PostMapping("/memberinfo")
    public String memberinfo(MemberDto updateDto){
        MemberDto memberDto = (MemberDto) session.getAttribute("loginuser");
        Long id = memberDto.getId();
        memberService.memberupdate(id, updateDto);
        return "redirect:/memberinfo";
    }

}
