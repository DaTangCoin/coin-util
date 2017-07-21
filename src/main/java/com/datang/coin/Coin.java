package com.datang.coin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

	private String id;
	private String name;
	private String year;
	private String size;
	private String price;
	private String price68;
	private String price69;
	private String price70;
	private String quantity;
	private String imageUrlLarge;
	private String imageUrlSmall;
	private String priceUrl;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String objectId;
	


	public void setId(String id){
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public void setPrice68(String price){
		this.price68 = price;
	}

	public void setPrice69(String price){
		this.price69 = price;
	}

	public void setPrice70(String price){
		this.price70 = price;
	}

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public void setImageUrlLarge(String url){
		this.imageUrlLarge = url;
	}

	public void setImageUrlSmall(String url){
		this.imageUrlSmall = url;
	}

	public String getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public String getSize(){
		return size;
	}

	public String getPrice() {
		return price;
	}

	public String getPrice68(){
		return price68;
	}

	public String getPrice69(){
		return price69;
	}

	public String getPrice70(){
		return price70;
	}

	public String getQuantity(){
		return quantity;
	}

	public String getImageUrlLarge(){
		return imageUrlLarge;
	}

	@Override
	public String toString() {
		return "Coin [id=" + id + ", name=" + name + ", year=" + year + ", size=" + size + ", price=" + price
				+ ", price68=" + price68 + ", price69=" + price69 + ", price70=" + price70 + ", quantity=" + quantity
				+ ", imageUrlLarge=" + imageUrlLarge + ", imageUrlSmall=" + imageUrlSmall + ", objectId=" + objectId
				+ "]";
	}

	public String getImageUrlSmall(){
		return imageUrlSmall;
	}
	
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getPriceUrl() {
		return priceUrl;
	}

	public void setPriceUrl(String priceUrl) {
		this.priceUrl = priceUrl;
	}
}
