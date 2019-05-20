package com.myproduct.repository;

import com.myproduct.entity.SurveyVote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyVoteRepository extends CrudRepository<SurveyVote, Long>  {
    List<SurveyVote> findByProductId(long productId);
}
