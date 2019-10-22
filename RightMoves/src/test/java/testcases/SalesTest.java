package testcases;

import java.util.Map;

import base.BaseTest;
import pages.LandingPage;
import pages.SaleDetailSearchPage;
import pages.SaleSearchResultsPage;
import pages.abs.SearchResultsPage.SortOrder;
import utilities.ReadExcel;

public class SalesTest extends BaseTest{
	
	public static void main(String[] args) {
		Map<String, String> salesData = ReadExcel.readExcelData("sales");
		launchBrowser();
		LandingPage landingPage = new LandingPage(driver);
		SaleDetailSearchPage saleDetailSearchPage = landingPage.searchPropertyForSale(salesData.get("location"));
		saleDetailSearchPage.setRadius(salesData.get("searchRadius"));
		saleDetailSearchPage.setMinPrice(salesData.get("minPriceRange"));
		saleDetailSearchPage.setMaxPrice(salesData.get("maxPriceRange"));
		saleDetailSearchPage.setMinBedroom(salesData.get("minBedRoom"));
		saleDetailSearchPage.setMaxBedroom(salesData.get("maxBedRoom"));
		saleDetailSearchPage.setPropertyType(salesData.get("PropertyType"));
		saleDetailSearchPage.setAddedSince(salesData.get("AddedToSite"));
		SaleSearchResultsPage saleSearchResultsPage = saleDetailSearchPage.findProperties();
		saleSearchResultsPage.sortBy(SortOrder.NEWEST_LISTED);
		saleSearchResultsPage.openFirstNonFeaturedProperty();
	}
}
