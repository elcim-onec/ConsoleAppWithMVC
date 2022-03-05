package com.company.model.entity;

//Positive, Neutral, Negative
public class Sentiment {
    private Integer id;
    private String sentimentType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentimentType() {
        return sentimentType;
    }

    public void setSentimentType(String sentimentType) {
        this.sentimentType = sentimentType;
    }


    public Sentiment(Integer id, String sentimentType) {
        this.id = id;
        this.sentimentType = sentimentType;
    }


    public Sentiment(String sentimentType) {
        this(null,sentimentType);
    }

    @Override
    public String toString() {
        return "\n\n Sentiment--->  id: " + id + ", Type: " + sentimentType + "";
    }
}
