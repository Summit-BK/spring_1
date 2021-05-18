package spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import spring.domain.MemberEntity;

@Getter
@Setter
public class MemberDto {

    private Long id;
    private String memberid;
    private String password;
    private String name;
    private String email;

    @Builder
    public MemberDto(Long id, String memberid, String password, String name, String email){
        this.id = id;
        this.memberid = memberid;
        this.password = password;
        this.name = name;
        this. email = email;
    }

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .memberid(memberid)
                .name(name)
                .password(password)
                .email(email).build();
    }


}
