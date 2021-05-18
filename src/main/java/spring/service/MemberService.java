package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.domain.MemberEntity;
import spring.domain.MemberRepository;
import spring.web.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long membersave(MemberDto memberDto){
        return memberRepository.save(memberDto.toEntity()).getId();
    }


    public List<MemberDto> memberlist(){
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDto> memberDtoList = new ArrayList<>();

        for(MemberEntity temp : memberEntityList){
            MemberDto memberDto = MemberDto.builder()
                    .id(temp.getId())

                    .memberid(temp.getMemberid())
                    .password(temp.getName())
                    .name(temp.getName())
                    .email(temp.getEmail()).build();
            memberDtoList.add(memberDto);
        }
        return memberDtoList;
    }


}



