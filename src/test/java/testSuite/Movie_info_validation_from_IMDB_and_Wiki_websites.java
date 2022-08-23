package testSuite;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

public class Movie_info_validation_from_IMDB_and_Wiki_websites extends Base {

	public WebDriver driver;
	public Properties prop;

	@BeforeTest
	public void initialize_driver() throws IOException {

		initializeDriver();

	}

	@Test

	public void IMDB_and_Wiki_Page_Navigation() throws IOException {

		String IMDB_url = getValueOf ("IMDB_url");
		launch_Url(IMDB_url);
		perform_Action().moveToElement(IMDBpage().goTo_Sidescreen()).perform();
		
		String Movie_Name = getValueOf("Movie_Name");
		IMDBpage().goTo_IMDB_Search().sendKeys(Movie_Name);
		IMDBpage().goTo_IMDB_Search().sendKeys(Keys.ENTER);
		IMDBpage().goTo_Searched_Movie_In_IMDB().click();
		
		perform_Action().moveToElement(IMDBpage().goTo_CountryOfOrigin_Text()).perform();

		String countryName_In_IMDB = IMDBpage().goTo_Countryname_Of_Searched_Movie_In_IMDB_Portal().getText();
		System.out.println("Country name in IMDB : " + countryName_In_IMDB);

		String releaseDetails_In_IMDB = IMDBpage().goTo_Releasedate_Of_Searched_Movie_In_IMDB_Portal().getText();
		String releaseDate_In_IMDB = format_Date_as_dd_month_yyyy(releaseDetails_In_IMDB);
		System.out.println("Release Date in IMDB : " + releaseDate_In_IMDB);

		String Wiki_url = getValueOf("Wiki_url");
		launch_Url(Wiki_url);
		applying_Wait_Implicitly_In_Seconds(5);
		Wikipage().goTo_Wiki_Search().sendKeys(Movie_Name);
		Wikipage().goTo_Wiki_Search().sendKeys(Keys.ENTER);
		Wikipage().goTo_Searched_Movie_In_Wiki().click();
		
		perform_Action().moveToElement(Wikipage().goTo_Country_Text()).perform();
		String countrynName_In_Wiki = Wikipage().goTo_Countryname_Of_Searched_Movie_In_Wiki_Portal().getText();
		System.out.println("Country name in Wiki  : " + countrynName_In_Wiki);
		String releaseDate_In_Wiki = Wikipage().goTo_Releasedate_Of_Searched_Movie_In_Wiki_Portal().getText();
		System.out.println("Release Date in Wiki : " + releaseDate_In_Wiki);
		
		
		Assert.assertTrue(countryName_In_IMDB.equalsIgnoreCase(countrynName_In_Wiki));
		
		Assert.assertTrue(releaseDate_In_IMDB.equalsIgnoreCase(releaseDate_In_Wiki));

	}

	@AfterTest
	public void teardown() {

		 quit_Driver();

	}

}
