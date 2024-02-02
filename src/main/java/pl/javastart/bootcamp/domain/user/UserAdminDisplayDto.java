package pl.javastart.bootcamp.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserAdminDisplayDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<String> roles;
}
