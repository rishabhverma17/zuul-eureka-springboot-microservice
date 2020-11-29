package com.rishabh.movieratingservice.resource;

import com.rishabh.movieratingservice.model.Rating;
import com.rishabh.movieratingservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingResource {
    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratingsList = Arrays.asList(
                new Rating("1234",3),
                new Rating("5678",4)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratingsList);
        return userRating;
    }
}
