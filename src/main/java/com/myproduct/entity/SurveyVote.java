package com.myproduct.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SurveyVote")
@Getter
@Setter
public class SurveyVote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long surveyId;
    @Column
    private long productId;
    @Column
    private int vote;

}
