package movie.service;

import com.example.movie.dto.MovieReqDto;
import com.example.movie.service.MovieApiClient;
import org.junit.jupiter.api.Test;

class MovieApiClientTest {

    private MovieApiClient movieApiClient = new MovieApiClient();
    @Test
    void requestMovie() {
        var search = new MovieReqDto();
        search.setQuery("스파이더맨");
        search.setGenre("19");
        var res = movieApiClient.requestMovie(search);
        System.out.println(res);
    }
}