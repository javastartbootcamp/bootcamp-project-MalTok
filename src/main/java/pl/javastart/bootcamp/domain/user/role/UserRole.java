package pl.javastart.bootcamp.domain.user.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.javastart.bootcamp.domain.user.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return role.name();
    }
}
