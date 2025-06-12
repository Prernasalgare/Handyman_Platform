package com.handymanServices.entity;

import jakarta.persistence.*;

@Entity
public class Handyman1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String skill;
    private double rating;
    private int reviewsCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getReviewsCount() {
		return reviewsCount;
	}
	public void setReviewsCount(int reviewsCount) {
		this.reviewsCount = reviewsCount;
	}

   
}
