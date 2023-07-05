package com.example.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String userName;

    @Size(min=7)
    @NotBlank
    String password;

    @Email
    @NotBlank
    String email;

    @Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
    @NotBlank
    String phoneNumber;

    public User(String userName, String password, String email, String phoneNumber){
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.phoneNumber=phoneNumber;
    }
}
