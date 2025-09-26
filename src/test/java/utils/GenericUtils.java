package utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	String parentWID, childWID;
	WebDriver driver;
	public HashMap<String, Integer> topDealProdDetail= new HashMap<String, Integer>();
	
	public GenericUtils(WebDriver driver) {
		this.driver= driver;
	}
	
	public void switchToChildSite() {
		Set<String> myCarts= driver.getWindowHandles();
		Iterator<String> i1= myCarts.iterator();
	    parentWID=i1.next();
	    childWID=i1.next();

	    driver.switchTo().window(childWID);
	}
	
	public int getDiff(String amnt1, String amnt2) {
		return Integer.parseInt(amnt1) -Integer.parseInt(amnt2);
	}
	
//	print the elements in the hashmap
	
	public HashMap<String, Integer> getTopDeals() {
		return topDealProdDetail;
	}
}
