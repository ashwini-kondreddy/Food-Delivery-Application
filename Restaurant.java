package com.tap.model;

import java.sql.Timestamp;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String adminId;
	private String address;
	private String cuisineType; 
	private int rating;
	private String ETA; 
	private String imageUrl;
	private String isAvaliable;
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getETA() {
		return ETA;
	}
	public void setETA(String eTA) {
		ETA = eTA;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getIsAvaliable() {
		return isAvaliable;
	}
	public void setIsAvaliable(String isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	
	
	public Restaurant(int restaurantId, String name, String adminId, String address, String cuisineType, int rating,
			String eTA, String imageUrl, String isAvaliable) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.adminId = adminId;
		this.address = address;
		this.cuisineType = cuisineType;
		this.rating = rating;
		ETA = eTA;
		this.imageUrl = imageUrl;
		this.isAvaliable = isAvaliable;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", adminId=" + adminId + ", address="
				+ address + ", cuisineType=" + cuisineType + ", rating=" + rating + ", ETA=" + ETA + ", imageUrl="
				+ imageUrl + ", isAvaliable=" + isAvaliable + "]";
	}
	
	
	
}
