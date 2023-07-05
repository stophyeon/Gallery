package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResDto {
    private Integer display;
    private List<SearchMovieItem> items;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchMovieItem{
        private String title;
        private String link;
        private Date pubDate;
        private String director;
        private Integer userRating;
        private String actor;

    }


}
