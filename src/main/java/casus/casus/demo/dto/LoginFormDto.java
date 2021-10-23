package casus.casus.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class LoginFormDto {
    private String userName;
    private String password;



    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(userName, password);
    }
}
