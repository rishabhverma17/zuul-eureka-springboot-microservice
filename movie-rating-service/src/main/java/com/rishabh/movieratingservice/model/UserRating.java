package com.rishabh.movieratingservice.model;

import lombok.Data;

import java.util.List;

@Data
public class UserRating {
    private String userId;
    private List<Rating> ratings;
}
