package edu.csupomona.cs480.data;

import java.util.Date;

import edu.csupomona.cs480.util.IdGiver;


/**
 * The basic user object.
 */
public class Item {

	/** The unique user Id */
    private String id;
 // storeCode are 1, 2, 3 for now
    private String storeCode;
    /** The unique user Id */
    private String name;
    /** The unique user Id */
    private String price;
    
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    // Start Builder Patter
    public static class Builder{
    	private String id;
    	private String storeCode;
    	private String name;
    	private String price;
    	
    	public Builder(String id) {
    		this.id = id;
    	}
    	public Builder storeCode(String sc) {
    		this.storeCode = sc;
    		return this;
    	}
    	public Builder name(String name) {
    		this.name = name;
    		return this;
    	}
    	public Builder price(String price) {
    		this.price = price;
    		return this;
    	}
    	public Item build() {
    		return new Item(this);
    	}
    }
    
    private Item(Builder b) {
    	this.id = b.id;
		this.storeCode = b.storeCode;
		this.name = b.name;
		this.price = b.price;
    }
    // END Builder Pattern

    
    
    /**
	 * 
	 */
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
}
