package pl.javastart.bootcamp.domain.contact;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Valid
@Data
public class ContactDto {
    @NotBlank(message = "Imię nie może być puste")
    private String userName;
    @Email(message = "Podaj poprawny adres e-mail z @")
    @NotBlank(message = "E-mail nie może być pusty")
    private String userEmail;
    @NotBlank(message = "Wiadomość nie może być pusta")
    private String message;
}
