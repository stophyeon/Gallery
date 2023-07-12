package com.example.movie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user_table")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<MyMovies> movies = new ArrayList<>();
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
