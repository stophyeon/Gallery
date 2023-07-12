package com.example.movie.controller;

import com.example.movie.dto.SearchReq;
import com.example.movie.dto.SearchRes;
import com.example.movie.service.MovieSearchAPI;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {
    private MovieSearchAPI movieSearchAPI;
    public SearchController(MovieSearchAPI movieSearchAPI){this.movieSearchAPI=movieSearchAPI;}
    @PostMapping("/movie/search")
    public String search(SearchReq searchReq, Model model) throws IOException, ParseException {

        List<SearchRes> movies = movieSearchAPI.searchMovie(searchReq);

        model.addAttribute("movies",movies);
        return "movies";
    }
    @PostMapping("/movie/like")
    public String MyMovies(SearchRes searchRes){

        return "mypage";
    }
}
