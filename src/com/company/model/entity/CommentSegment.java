package com.company.model.entity;

//Relevant, Spam, Other
public class CommentSegment {
    private Integer id;
    private String commentType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public CommentSegment(Integer id, String commentType) {
        this.id = id;
        this.commentType = commentType;
    }

    public CommentSegment(String commentType) {
        this(null,commentType);
    }

    @Override
    public String toString() {
        return "\n\n Comment Segment--->  id: " + id + ", Type: " + commentType + "";
    }
}
