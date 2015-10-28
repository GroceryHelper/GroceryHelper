package edu.csupomona.cs480;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import edu.csupomona.cs480.data.User;
import junit.framework.Assert;

public class UserTest {

	@Test
	public void test() {
		
		// Simple test case for a simple class
		
		final String id = "10101010";
		final String name = "Grocery Helper";
		final String major = "CS";
		final String creationTime = new Date(System.currentTimeMillis()).toString();
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setMajor(major);
		user.setCreationTime(creationTime);
		
		Assert.assertEquals(id, user.getId());
		Assert.assertEquals(name, user.getName());
		Assert.assertEquals(major, user.getMajor());
		Assert.assertEquals(creationTime, user.getCreationTime());	
	}

}
