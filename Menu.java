package com.tap.model;

public class Menu {
	private int menuId;
	private int restaurantId; 
	private String name;
	private String description;
	private int price;
	private int rating;
	private String imageURL;
	private String type;
	private String isAvaliable;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsAvaliable() {
		return isAvaliable;
	}
	public void setIsAvaliable(String isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	
	
	
	public Menu(int menuId, int restaurantId, String name, String description, int price, int rating, String imageURL,
			String type, String isAvaliable) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.imageURL = imageURL;
		this.type = type;
		this.isAvaliable = isAvaliable;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + name + ", description="
				+ description + ", price=" + price + ", rating=" + rating + ", imageURL=" + imageURL + ", type=" + type
				+ ", isAvaliable=" + isAvaliable + "]";
	}
	
	
}
