package com.example.movie.controller;

import com.example.movie.dto.SearchReq;
import com.example.movie.dto.SearchRes;
import com.example.movie.entity.User;
import com.example.movie.service.MovieSearchAPI;
import com.example.movie.service.MovieService;
import com.example.movie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieSearchAPI movieSearchAPI;
    private final MovieService movieService;
    private final UserService userService;
    @PostMapping("/movie/search")
    public String search(SearchReq searchReq, Model model) throws IOException, ParseException {

        List<SearchRes> movies = movieSearchAPI.searchMovie(searchReq);

        model.addAttribute("movies",movies);
        return "movies";
    }
    @GetMapping("/movie/user/like")
    public String MyMovies(){return "mymovie";}
    @PostMapping("/movie/user/like")
    public String addMyMovies(String title,String email,Model model) throws IOException, ParseException {
        SearchReq searchReq = new SearchReq(title);
        User user = userService.findOne(email);
        SearchRes movie=movieSearchAPI.searchMovie(searchReq).get(0);
        movieService.addMovies(movie,user);
        model.addAttribute("member",user);
        return "mymovie";
    }
}
