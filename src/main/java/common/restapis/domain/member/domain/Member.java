package common.restapis.domain.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class Member {

    private Long id;

    @NotBlank(message = "이름을 입력해주세요")
    private String userName;

    @NotBlank(message = "아이디를 입력해주세요")
    private String userId;

    @Size(min = 5, max = 10, message = "비밀번호는 5자 이상 10자 이하입니다.")
    @NotBlank
    private String password;

    public Member(String userName, String userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
