package edu.csupomona.cs480.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Joiner;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.Item;
import edu.csupomona.cs480.data.provider.ItemManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private ItemManager itemManager;

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	@RequestMapping(value = "/cs480/ping2", method = RequestMethod.GET)
	String showInfo() {
		return "Samuel is an owl. Woo woo!";
	}

	@RequestMapping(value = "/cs480/grocery", method = RequestMethod.GET)
	String groceryCheck() {
		return "Grocery!!!";
	}

	@RequestMapping(value = "/cs480/ping1", method = RequestMethod.GET)
	String teamMembers(){
		return "Jasmeet Kaur, Samuel Jih, Su Jeong Ha";
	}	

	// Testing jsoup 
	@RequestMapping(value = "/cs480/jsoup", method = RequestMethod.GET)
	String jSoupTest(){
		Document doc;
		String title = null;
		String lastItemText = null;
		try {
			// Albertson's data
			doc = Jsoup.connect("http://albertsons.mywebgrocer.com/Circular/Chino-Hills-Los-Serranos-and-Soquel-Canyon/C5C273633/Weekly/1").get();
			
			// get page title
			title = doc.title();
			System.out.println("title : " + title);
			
			Elements items = doc.select("p");
			for (Element item : items) {

				System.out.println("item text : " + item.text());
				lastItemText = item.text();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lastItemText;
	}
	// END Testing jsoup

	@RequestMapping(value = "/cs480/guava", method = RequestMethod.GET)
	String getPrice(String search) {
		Table<String, String, Double> table = HashBasedTable.create();
		Double itemPrice = 0.0;

		table.put("Fruits", "Apple", 0.99);
		table.put("Fruits", "Orange", 1.49);
		table.put("Fruits", "Banana", 2.00);

		Table transponedTable = Tables.transpose(table);

		Map<String, Double> fruits =  table.row("Fruits");

		System.out.println("List of Fruits");

		for(Map.Entry<String, Double> entry : ((Map<String, Double>) table).entrySet()) {
			if (search.equals(entry.getKey())) {
				itemPrice = entry.getValue();
			}
		}

		return ("This week's low price for " + search + " is " + itemPrice);
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	
	@RequestMapping(value = "/cs480/item/{itemId}", method = RequestMethod.GET)
	Item getItem(@PathVariable("itemId") String itemId) {
		Item item = itemManager.getItem(itemId);
		return item;
	}
	
	
	

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param price
	 * @return
	 */
	@RequestMapping(value = "/cs480/item/{itemId}", method = RequestMethod.POST)
	Item updateItem(
			@PathVariable("itemId") String id,
			@RequestParam("storeCode") String code,
			@RequestParam(value="name", required = false) String name,
			@RequestParam(value = "price", required = false) String price) {
		Item item = new Item();
		item.setId(id);
		item.setStoreCode(code);
		item.setPrice(price);
		item.setName(name);
		itemManager.updateItem(item);
		return item;
	}
	
	// this is to save zip user entered
	@RequestMapping(value = "/cs480/zip/{zipCode}", method = RequestMethod.POST)
	String saveZip(
			@PathVariable("zipCode") String zipCode,
			@RequestParam("zipCode") String zip) {
//		Item user = new Item();
//		user.setId(id);
//		user.setPrice(price);
//		user.setName(name);
//		userManager.updateItem(user);
		return zip;
	}
	

	@RequestMapping(value = "/cs480/zip/{zipCode}", method = RequestMethod.GET)
	String getZip(@PathVariable("zipCode") String zip) {
//		Item user = userManager.getItem(itemId);
		return zip;
	}
	
	
	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/item/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		itemManager.deleteItem(userId);
	}



	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */

	@RequestMapping(value = "/cs480/items/list", method = RequestMethod.GET)
	List<Item> listAllItems() {
		return itemManager.listAllItems();
	}


	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllItems());
		return modelAndView;
	}
	
}
