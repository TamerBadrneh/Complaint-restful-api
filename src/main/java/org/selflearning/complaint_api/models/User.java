package org.selflearning.complaint_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    @NotBlank(message = "Name can't be blank")
    @Length(max = 50, message = "Name can't exceed 50 characters.")
    private String name;

    @Column(name = "DATE_OF_CREATION",  nullable = false)
    private LocalDate dateOfCreation = LocalDate.now();

    @Column(name = "EMAIL", nullable = false)
    @Email(message = "Invalid Email Format.")
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @NotBlank(message = "Password Can't be blank.")
    @Length(min = 8, message = "Minimum Length required is 8 characters")
    private String password;
}
