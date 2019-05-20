package com.myproduct.controller;

import com.myproduct.entity.SurveyVote;
import com.myproduct.response.ResponseVote;
import com.myproduct.service.SurveyVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SurveyVoteController {
    @Autowired
    private SurveyVoteService surveyVoteService;

    @RequestMapping(value = "/addVote", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody SurveyVote surveyVote) throws URISyntaxException {

        SurveyVote vote = surveyVoteService.createSurveyVote(surveyVote);
        return new ResponseEntity<>(vote, HttpStatus.OK);

    }

    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    public List<SurveyVote> getSurveyAllProductList() {

        return surveyVoteService.getList();

    }

    @RequestMapping(value = "/getProductVote/{productId}", method = RequestMethod.GET)
    public List<ResponseVote> getSurveyAllProductList(@PathVariable long productId) {

        return surveyVoteService.getProductVote(productId);

    }
}
