package com.company.model.entity;

//Dissatisfied or Satisfied
public class Score {
    private Integer id;
    private String score_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScoreType() {
        return score_type;
    }

    public void setScoreType(String score_type) {
        this.score_type = score_type;
    }

    public Score(Integer id,String score_type) {
        this.id =id;
        this.score_type = score_type;
    }


    public Score(String score_type) {
        this(null,score_type);
    }

    @Override
    public String toString() {
        return "\n\nScore---> id: " + id + ", Type: " + score_type + "";
    }

}
