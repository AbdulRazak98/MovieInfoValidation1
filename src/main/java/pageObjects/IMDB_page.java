package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDB_page {

	WebDriver driver;

	public IMDB_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//span[text()='Up next']")
	WebElement sideScreen;
	
	@FindBy(css = "[class*='_input search']")
	WebElement search;

	@FindBy(xpath = "//table[@class='findList']/tbody/tr[1]/td")
	WebElement first_movie_displayed;
	
	@FindBy(xpath = "//span[text()='Country of origin']")
	WebElement country_of_origin_text;

	@FindBy(xpath = "//span[text()='Country of origin']/following-sibling::div")
	WebElement country_name;

	@FindBy(xpath = "//*[text()='Release date']/following-sibling::div")
	WebElement release_date;
	
	public WebElement goTo_Sidescreen() {
		
		return sideScreen;
		
	}
	public WebElement goTo_IMDB_Search() {
		
		return search;
	}

	public WebElement goTo_Searched_Movie_In_IMDB() {
		
		return first_movie_displayed;
	}
	
	public WebElement goTo_CountryOfOrigin_Text() {

		return country_of_origin_text;

	}

	public WebElement goTo_Countryname_Of_Searched_Movie_In_IMDB_Portal() {

		return country_name;

	}

	public WebElement goTo_Releasedate_Of_Searched_Movie_In_IMDB_Portal() {

		return release_date;

	}

}
