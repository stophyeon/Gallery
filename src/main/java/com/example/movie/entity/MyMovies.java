package com.example.movie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor

@Getter
@Table(name = "movie_table")
public class MyMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movies_id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String poster_path;
    private String title;


    public MyMovies(String poster_path, String title,User user) {
        this.poster_path = poster_path;
        this.title = title;
        this.user=user;
    }
}
