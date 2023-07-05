package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieReqDto {
    private String query;
    private String genre;
    public MultiValueMap<String,String> toMap(){
        var map=new LinkedMultiValueMap<String,String>();
        map.add("query",query);
        map.add("genre",genre);
        return map;
    }
}
