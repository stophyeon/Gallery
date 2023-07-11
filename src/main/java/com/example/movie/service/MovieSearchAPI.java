package com.example.movie.service;

import com.example.movie.dto.SearchReq;

import com.example.movie.dto.SearchRes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.*;

@Service
public class MovieSearchAPI {
    private final String url = "https://api.themoviedb.org/3/search/movie";
    private final String key = "73b8a45b717547a965c0d9a015f1fdf9";
    public List<SearchRes> searchMovie(SearchReq searchReq) throws IOException, ParseException {
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("query",searchReq.getQuery())
                .queryParam("api_key",key)
                .queryParam("language",searchReq.getLanguage())
                .build()
                .encode()
                .toUri();
        //uri를 통해 tmdb 서버와 통신하는 부분
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate.getForEntity(uri, String.class);
        List<SearchRes> movies = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(response.getBody().toString());
        JSONArray jsonArray = (JSONArray)jsonObject.get("results");
        for (int i=0; i< jsonArray.size(); i++){
            JSONObject jsonObject1 =(JSONObject)jsonArray.get(i);
            String title = (String)jsonObject1.get("title");
            String overview = (String)jsonObject1.get("overview");
            String poster_path = "https://image.tmdb.org/t/p/w500"+(String)jsonObject1.get("poster_path");
            Double vote_average = (Double)jsonObject1.get("vote_average");
            movies.add(new SearchRes(title,overview,poster_path,vote_average));
        }
        return movies;
















    }


}
