package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.Item;
import edu.csupomona.cs480.data.ItemMap;
import edu.csupomona.cs480.util.ResourceResolver;

/**
 * The implementation of {@link ItemManager} interface
 * using file system.
 * <p>
 * This class demonstrates how you can use the file system
 * as a database to store your data.
 *
 */
public class FSItemManager implements ItemManager {

	/**
	 * We persist all the user related objects as JSON.
	 * <p>
	 * For more information about JSON and ObjectMapper, please see:
	 * http://www.journaldev.com/2324/jackson-json-processing-api-in-java-example-tutorial
	 *
	 * or Google tons of tutorials
	 *
	 */
	private static final ObjectMapper JSON = new ObjectMapper();

	/**
	 * Load the user map from the local file.
	 *
	 * @return
	 */
	private ItemMap getItemMap() {
		ItemMap itemMap = null;
		File userFile = ResourceResolver.getItemFile();
		System.out.println("Files? " + userFile.getName());
		System.out.println("file exist? " + userFile.exists());
		if (userFile.exists()) {
			// read the file and convert the JSON content
			// to the UserMap object
			try {
				
				itemMap = JSON.readValue(userFile, ItemMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			itemMap = new ItemMap();
		}
		return itemMap;
	}

	/**
	 * Save and persist the user map in the local file.
	 *
	 * @param userMap
	 */
	private void persistItemMap(ItemMap userMap) {
		try {
			// convert the user object to JSON format
			JSON.writeValue(ResourceResolver.getItemFile(), userMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item getItem(String userId) {
		ItemMap userMap = getItemMap();
		return userMap.get(userId);
	}

	@Override
	public void updateItem(Item user) {
		ItemMap userMap = getItemMap();
		userMap.put(user.getId(), user);
		persistItemMap(userMap);
	}

	@Override
	public void deleteItem(String userId) {
		ItemMap userMap = getItemMap();
		userMap.remove(userId);
		persistItemMap(userMap);
	}

	@Override
	public List<Item> listAllItems() {
		ItemMap userMap = getItemMap();
		return new ArrayList<Item>(userMap.values());
	}
}
