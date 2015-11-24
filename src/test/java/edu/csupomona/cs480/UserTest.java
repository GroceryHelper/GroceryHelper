package edu.csupomona.cs480;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import edu.csupomona.cs480.data.Item;
import junit.framework.Assert;

public class UserTest {

	@Test
	public void test() {
		String id = "0101010";
		String storeName = "GroceryHelper";
		String price = "CS";
		String creationTime = new Date(System.currentTimeMillis()).toString();
		
		// builder pattern
		Item user = new Item.Builder(id).storeCode(storeName).price(price).build();
		
		
		Assert.assertEquals(id, user.getId());
		Assert.assertEquals(storeName, user.getStoreCode());
		Assert.assertEquals(price, user.getPrice());
		Assert.assertEquals(creationTime, user.getCreationTime());
		
	}

}
