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
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
//    public void setId() {
//        this.id = IdGiver.getUniqueId();
//    }

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
