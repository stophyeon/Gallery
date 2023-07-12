package com.example.movie.service;

import com.example.movie.dto.SearchRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieServiceTest {
    @Autowired
    MovieService movieService;
    @Test
    void addMovies() {
        SearchRes searchRes = new SearchRes("아이언맨","멋짐","이쪽",9.8);
        movieService.addMovies(searchRes);

        System.out.println(movieService.findMovieByTitle(searchRes.getTitle()));
    }

    @Test
    void showMovies() {
    }
}