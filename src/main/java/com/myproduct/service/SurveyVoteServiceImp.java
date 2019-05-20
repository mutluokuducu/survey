package com.myproduct.service;

import com.myproduct.entity.Survey;
import com.myproduct.entity.SurveyVote;
import com.myproduct.repository.SurveyRepository;
import com.myproduct.repository.SurveyVoteRepository;
import com.myproduct.response.ResponseVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyVoteServiceImp implements SurveyVoteService {

    @Autowired
    private SurveyVoteRepository surveyVoteRepository;


    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public SurveyVote createSurveyVote(SurveyVote surveyVote) {
        return surveyVoteRepository.save(surveyVote);
    }

    @Override
    public List<SurveyVote> getList() {
        List<SurveyVote> getAllList= (List<SurveyVote>) surveyVoteRepository.findAll();
        return getAllList;
    }

    @Override
    public List<ResponseVote> getProductVote(long productId) {


        List<SurveyVote> surveyVotes=surveyVoteRepository.findByProductId(productId);
        List<Survey> surveys= (List<Survey>) surveyRepository.findAll();

        List<ResponseVote> responseVotes= surveyVotes.stream()
                .map(x -> {
                    ResponseVote responseVote = new ResponseVote();
                    responseVote.setProductId(productId);
                    responseVote.setVote(x.getVote());
                    if(x.getVote()==1){

                        responseVote.setMessage("oh dear :(");
                    }else if(x.getVote()==5){
                        responseVote.setMessage("Wow, I’m impressed!");
                    }

                    Survey survey=surveys.stream()
                            .filter(m ->m.getId()==x.getSurveyId())

                            .findFirst()
                            .orElseThrow(() -> new IllegalStateException("Error!"));


                    responseVote.setSurveyText(survey.getSurveyText());



                    return responseVote;
                }).collect(Collectors.toList());




        return responseVotes;
    }
}
