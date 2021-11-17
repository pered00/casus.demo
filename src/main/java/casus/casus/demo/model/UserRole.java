package casus.casus.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_role_tbl")
public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;
    private String role;


    @Override
    public String getAuthority() {
        return role;
    }


//    USER, ADMIN, ASSISTANT, BACKOFFICE

}
