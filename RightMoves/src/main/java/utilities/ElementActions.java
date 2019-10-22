package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected Actions actions;
	public ElementActions(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor)driver;
		actions = new Actions(driver);
	}
	
	public enum DropDownType{
		BY_INDEX, BY_VALUE, BY_VISIBLE_TEXT
	}
	public void clickOn(By locator){
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	
	public void enterText(By locator, String text){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).sendKeys(text);
	}
	
	public void selectInDropDown(By locator, DropDownType type, Object value){
		Select sel = new Select(driver.findElement(locator));
		switch(type){
		case BY_INDEX:
			sel.selectByIndex(((Integer)value).intValue());
			break;
		case BY_VALUE:
			sel.selectByValue((String)value);
			break;
		case BY_VISIBLE_TEXT:
			sel.selectByVisibleText((String)value);
		}
	}
	
	public void scrollIntoView(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(locator));
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public String getElementText(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
	
	public String getElementAttribute(By locator, String attribute){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator).getAttribute(attribute);
	}
	
	public void waitInSeconds(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
