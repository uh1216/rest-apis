package common.restapis.domain.member.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class Member {

    private Long id;
    private String userName; //ToDo 검증 만들기
    private String userId;
    private String password;

    public Member(String userName, String userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
