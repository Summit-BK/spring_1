package spring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String memberid;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Builder
    public MemberEntity(Long id, String memberid, String password, String name, String email){

        this.id = id;
        this.memberid = memberid;
        this.password = password;
        this.name = name;
        this. email = email;
    }



}
