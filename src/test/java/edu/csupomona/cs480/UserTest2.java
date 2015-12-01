package edu.csupomona.cs480;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import edu.csupomona.cs480.controller.WebController;
import edu.csupomona.cs480.data.Item;
import junit.framework.Assert;

public class UserTest2 {

	@Test
	public void test() {
		String id = "1111";
		String storeName = "Samuel";
		String price = "CS";
		String creationTime = new Date(System.currentTimeMillis()).toString();
		
//		Item user = new Item.Builder(id).storeCode(storeName).price(price).build();
		
		Item user = new Item();
		user.setId(id);
		user.setName(storeName);
		user.setCreationTime(creationTime);
		user.setPrice(price);
		
		Assert.assertEquals(id, user.getId());
//		Assert.assertEquals(storeName, user.getStoreCode());
		Assert.assertEquals(price, user.getPrice());
		Assert.assertEquals(creationTime, user.getCreationTime());		
	}

}
