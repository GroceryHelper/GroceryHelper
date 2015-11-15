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
		String name = "Samuel";
		String major = "CS";
		String creationTime = new Date(System.currentTimeMillis()).toString();
		
		Item user = new Item();
//		user.setId(id);
		user.setName(name);
		user.setPrice(major);
		user.setCreationTime(creationTime);
		
		Assert.assertEquals(id, user.getId());
		Assert.assertEquals(name, user.getName());
		Assert.assertEquals(major, user.getPrice());
		Assert.assertEquals(creationTime, user.getCreationTime());
		
	}

}
