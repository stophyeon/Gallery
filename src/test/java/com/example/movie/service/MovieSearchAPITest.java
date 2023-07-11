package com.example.movie.service;

import com.example.movie.dto.SearchReq;
import com.example.movie.dto.SearchRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class MovieSearchAPITest {
    @Autowired
    private MovieSearchAPI movieSearchAPI;

    @Test
    void searchMovie() throws IOException, ParseException {
        SearchReq searchReq = new SearchReq("범죄도시");
        List<SearchRes> movies = movieSearchAPI.searchMovie(searchReq);
        for (int i=0; i< movies.size(); i++){System.out.println(movies.get(i).getTitle());}




    }
}