package uz.pdp.exam7.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.exam7.abs.BaseEntity;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotBlank(message = "Iltimos ismingizni kiriting")
    @NotNull
    private String lastName;
    @NotBlank(message = "Iltimos familiyangizni kiriting")
    private String firstName;
    @Column(unique = true, nullable = false)
    @Email(message = "Iltimos emailingizni kiriting")
    private String email;
    @Column(nullable = false)
    @Size(min = 8, max = 16)
    private String password;
    private String role;


    public User(String lastName, String firstName, String email, String password, String role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
