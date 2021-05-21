package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.domain.MemberEntity;
import spring.domain.MemberRepository;
import spring.web.dto.MemberDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public MemberDto memberlogin(MemberDto loginDto){

        List<MemberEntity> memberEntityList = memberRepository.findAll();

        for(MemberEntity temp : memberEntityList){
            if(temp.getMemberid().equals(loginDto.getMemberid())&&temp.getPassword().equals(loginDto.getPassword())){

                MemberDto memberDto = MemberDto.builder()
                        .id(temp.getId())
                        .memberid(temp.getMemberid())
                        .name(temp.getName())
                        .email(temp.getEmail()).build();
                return memberDto;
            }

        }
        return null;

    }

    public MemberDto memberfind(Long id){

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);

        MemberEntity memberEntity = optionalMemberEntity.get();

        MemberDto memberDto = MemberDto.builder()
                .id(memberEntity.getId())
                .memberid(memberEntity.getMemberid())
                .name(memberEntity.getName())
                .password(memberEntity.getPassword())
                .email(memberEntity.getEmail()).build();
        return memberDto;
    }

    public int memberdelete(Long id){

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        MemberEntity memberEntity = optionalMemberEntity.get();
        memberRepository.delete(memberEntity);
        return 1;


    }
    @Transactional
    public int memberupdate(Long id,MemberDto updateDto){
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        MemberEntity memberEntity = optionalMemberEntity.get();
        memberEntity.update(updateDto);
        return 1;
    }

}




