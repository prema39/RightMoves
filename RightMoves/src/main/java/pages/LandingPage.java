package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	By searchTxtBox = By.id("searchLocation");
	By forSaleBtn = By.id("buy");
	By toRentBtn = By.id("rent");
	
	public SaleDetailSearchPage searchPropertyForSale(String locationName){
		enterText(searchTxtBox, locationName);
		clickOn(forSaleBtn);
		return new SaleDetailSearchPage(driver);
	}
	
	public RentDetailSearchPage searchPropertyForRent(String locationName){
		enterText(searchTxtBox, locationName);
		clickOn(toRentBtn);
		return new RentDetailSearchPage(driver);
	}

}
