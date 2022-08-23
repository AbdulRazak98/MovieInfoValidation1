package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wiki_page {

	WebDriver driver;

	public Wiki_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[name='search']")
	WebElement search;

	@FindBy(xpath = "//ul[@class='mw-search-results']/li/div/a")
	WebElement first_movie_displayed;

	@FindBy(xpath = "//th[text()='Country']")
	WebElement country_of_origin_text;

	@FindBy(xpath = "//th[text()='Country']/following-sibling::td")
	WebElement country_name;

	@FindBy(xpath = "//div[text()='Release date']/parent::th/following-sibling::td")
	WebElement release_date;

	public WebElement goTo_Wiki_Search() {

		return search;
	}

	public WebElement goTo_Searched_Movie_In_Wiki() {

		return first_movie_displayed;
	}

	public WebElement goTo_Country_Text() {

		return country_of_origin_text;

	}

	public WebElement goTo_Countryname_Of_Searched_Movie_In_Wiki_Portal() {

		return country_name;

	}

	public WebElement goTo_Releasedate_Of_Searched_Movie_In_Wiki_Portal() {

		return release_date;

	}

}
