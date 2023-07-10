package com.example.movie.service;

import com.example.movie.dto.SearchReq;
import com.example.movie.dto.SearchRes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@Service
public class MovieSearchAPI {
    private String url = "https://api.themoviedb.org/3/search/movie";
    private String key = "73b8a45b717547a965c0d9a015f1fdf9";
    public SearchRes searchMovie(SearchReq searchReq){
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("query",searchReq.getQuery())
                .queryParam("api_key",key)
                .queryParam("language",searchReq.getLanguage())
                .build()
                .encode()
                .toUri();
        RequestEntity<SearchReq> reqRequestEntity = new RequestEntity<>(HttpMethod.GET,uri);
        var responseType = new ParameterizedTypeReference<SearchRes>(){};
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SearchRes> searchRes = restTemplate.exchange(uri,HttpMethod.GET,reqRequestEntity,responseType);

        return searchRes.getBody();
    }

}
