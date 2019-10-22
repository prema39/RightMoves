package pages.abs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.SaleSearchResultsPage;

public abstract class DetailSearchPage extends BasePage{

	public DetailSearchPage(WebDriver driver) {
		super(driver);
	}

	
	By radius_by = By.id("radius");
	By minPrice_by = By.id("minPrice");
	By maxPrice_by = By.id("maxPrice");
	By minBedrooms_by = By.id("minBedrooms");
	By maxBedrooms_by = By.id("maxBedrooms");
	By propertyType_by = By.id("displayPropertyType");
	By addedToSite_by = By.id("maxDaysSinceAdded");
	By findProperties_by = By.id("submit");
	
	public void setRadius(String radius){
		selectInDropDown(radius_by, DropDownType.BY_VISIBLE_TEXT, radius);
	}
	
	public void setMinPrice(String minPrice){
		selectInDropDown(minPrice_by, DropDownType.BY_VALUE, minPrice);
	}
	
	public void setMaxPrice(String maxPrice){
		selectInDropDown(maxPrice_by, DropDownType.BY_VALUE, maxPrice);
	}
	
	public void setMinBedroom(String minBedroom){
		selectInDropDown(minBedrooms_by, DropDownType.BY_VISIBLE_TEXT, minBedroom);
	}
	
	public void setMaxBedroom(String maxBedroom){
		selectInDropDown(maxBedrooms_by, DropDownType.BY_VISIBLE_TEXT, maxBedroom);
	}
	
	public void setPropertyType(String propertyType){
		selectInDropDown(propertyType_by, DropDownType.BY_VISIBLE_TEXT, propertyType);
	}
	
	public void setAddedSince(String dateAdded){
		selectInDropDown(addedToSite_by, DropDownType.BY_VISIBLE_TEXT, dateAdded);
	}
	
	public SaleSearchResultsPage findProperties(){
		clickOn(findProperties_by);
		return new SaleSearchResultsPage(driver);
	}
}
