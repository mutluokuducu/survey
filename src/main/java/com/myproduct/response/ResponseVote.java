package com.myproduct.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVote {

    private String surveyText;
    private long productId;
    private int vote;
    private String message;

}
