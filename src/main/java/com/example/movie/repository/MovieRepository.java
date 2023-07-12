package com.example.movie.repository;

import com.example.movie.entity.MyMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MyMovies,Long> {
    public MyMovies findByTitle(String title);
}
