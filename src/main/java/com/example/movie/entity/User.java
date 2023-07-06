package com.example.movie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "user_table")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;
    String email;
    String phoneNumber;

    public User(String userName, String password, String email, String phoneNumber){
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.phoneNumber=phoneNumber;
    }
    public User(String email,String password){

        this.email=email;
        this.password=password;

    }
}
