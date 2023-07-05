package com.example.movie.service;

import com.example.movie.dto.MovieResDto;
import com.example.movie.dto.MovieReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class MovieApiClient {

    private String ClientId ="QAh1Ulk8CaqCnxnhjM8W";
    private String ClientSecret="6TNyZF9BxO";
    private String MovieSearch = "https://openapi.naver.com/v1/search/movie.json";

    public MovieResDto requestMovie(MovieReqDto movieReqDto) {
        var uri = UriComponentsBuilder.fromUriString(MovieSearch)
                .queryParams(movieReqDto.toMap())
                .build()
                .encode()
                .toUri();
        System.out.println(uri);
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",ClientId);
        headers.set("X-Naver-Client-Secret",ClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);
        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<MovieResDto>() {
        };
        var responseEntity = new RestTemplate().exchange(
                uri, HttpMethod.GET, httpEntity, responseType
        );
        return responseEntity.getBody();
    }
}
