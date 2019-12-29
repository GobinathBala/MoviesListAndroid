package com.example.task.Model;

public class Movie {

    private Integer id;
    private String image;
    private Integer is_new;
    private String rating;
    private Integer like_percent;
    private Integer vote_count;
    private String title;
    private String language;
    private String type;;


    public Movie(Integer id, String image, Integer is_new, String rating, Integer like_percent, Integer vote_count, String title, String language,String type) {
        this.id=id;
        this.image=image;
        this.is_new=is_new;
        this.rating=rating;
        this.like_percent=like_percent;
        this.vote_count=vote_count;
        this.title=title;
        this.language=language;
        this.type=type;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsNew() {
        return is_new;
    }

    public void setIsNew(Integer isNew) {
        this.is_new = isNew;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getLikePercent() {
        return like_percent;
    }

    public void setLikePercent(Integer likePercent) {
        this.like_percent = likePercent;
    }

    public Integer getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(Integer voteCount) {
        this.vote_count = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
