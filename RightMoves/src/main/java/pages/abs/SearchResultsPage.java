package pages.abs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pages.BasePage;
import pages.SalePropertyDetailPage;

public abstract class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	By sortType_by = By.id("sortType");
	By firstNonFeaturedProperty_by=By.xpath("(//div[@class='propertyCard' and not(contains(@class,'--featured'))]//a[@data-test='property-details'])[1]");
	
	public enum SortOrder{
		HIGHEST_PRICE, LOWEST_PRICE, NEWEST_LISTED, OLDEST_LISTED
	}

	public void sortBy(SortOrder order){
		
		Select sortSel = new Select(driver.findElement(sortType_by));
		switch(order){
		case HIGHEST_PRICE:
			sortSel.selectByVisibleText("Highest Price");
			break;
		case LOWEST_PRICE:
			sortSel.selectByVisibleText("Lowest Price");
			break;
		case NEWEST_LISTED:
			sortSel.selectByVisibleText("Newest Listed");
			break;
		case OLDEST_LISTED:
			sortSel.selectByVisibleText("Oldest Listed");
			break;
		}
		
	}
	
	public SalePropertyDetailPage openFirstNonFeaturedProperty(){
		waitInSeconds(3);
		scrollIntoView(firstNonFeaturedProperty_by);
		
		clickOn(firstNonFeaturedProperty_by);
		return new SalePropertyDetailPage(driver);
	}
	
}
