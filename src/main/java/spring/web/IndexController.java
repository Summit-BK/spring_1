package spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.service.MemberService;
import spring.web.dto.MemberDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;
    @GetMapping("/")
    public String index(Model model){

        List<MemberDto> memberDtoList = memberService.memberlist();
        model.addAttribute("memberDtoList",memberDtoList);

        return ("index");
    }
}
