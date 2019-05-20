package com.myproduct.service;

import com.myproduct.entity.SurveyVote;
import com.myproduct.response.ResponseVote;

import java.util.List;

public interface SurveyVoteService {
    SurveyVote createSurveyVote(SurveyVote surveyVote);
    List<SurveyVote> getList();
    List<ResponseVote> getProductVote(long productId);


}
