package project.usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.usermanager.domain.Gender;
import project.usermanager.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String id;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
    @NotBlank(message = "이름을 적어주세요.")
    private String name;
    @NotNull(message= "나이를 적어주세요.")
    private int age;
    @NotNull(message = "성별을 적어주세요.")
    private Gender gender;

    public User toEntity(){
        return User.builder()
                .id(id)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(name)
                .age(age)
                .gender(gender)
                .joinDate(LocalDateTime.now())
                .appendDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .state(false)
                .build();
    }
}
