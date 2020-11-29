package com.rishabh.moviecatalogservice.resource;

import com.rishabh.moviecatalogservice.models.CatalogItem;
import com.rishabh.moviecatalogservice.models.Movie;
import com.rishabh.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //RestTemplate restTemplate = new RestTemplate();
        UserRating ratingsList = restTemplate.getForObject("http://MOVIE-RATING-SERVICE/ratingsdata/user/"+ userId, UserRating.class);
        /*List<Rating> ratingsList = Arrays.asList(
                new Rating("1234",3),
                new Rating("5678",4)
        );*/

        return ratingsList.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
                    /*Movie movie = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8182/movies/" + rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class)
                            .block();*/
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());

        //return Collections.singletonList(new CatalogItem("transformer","test",8));
    }
}
