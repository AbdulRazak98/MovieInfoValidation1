package testSuite;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

public class Movie_info_validation_from_IMDB_and_Wiki_websites extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;
	public Properties prop;

	@BeforeTest
	public void initialize_driver() throws IOException {

		initializeDriver();
		log.info("Driver is initialized");

	}

	@Test

	public void IMDB_and_Wiki_Page_Navigation() throws IOException {

		String IMDB_url = getValueOf ("IMDB_url");
		launch_Url(IMDB_url);
		log.info("Launched IMDB url");
		perform_Action().moveToElement(IMDBpage().goTo_Sidescreen()).perform();
		
		String Movie_Name = getValueOf("Movie_Name");
		IMDBpage().goTo_IMDB_Search().sendKeys(Movie_Name);
		IMDBpage().goTo_IMDB_Search().sendKeys(Keys.ENTER);
		log.info("Entered  a movie name in the IMDB-Search text and clicked on Enter");
		IMDBpage().goTo_Searched_Movie_In_IMDB().click();
		log.info("navigated and clicked on the first movie displayed in the search results");
		
		perform_Action().moveToElement(IMDBpage().goTo_CountryOfOrigin_Text()).perform();

		String countryName_In_IMDB = IMDBpage().goTo_Countryname_Of_Searched_Movie_In_IMDB_Portal().getText();
		log.info("Grabbed Country name of searched movie from IMDB portal");
		System.out.println("Country name in IMDB : " + countryName_In_IMDB);
		log.info("Country name in IMDB : " + countryName_In_IMDB);

		String releaseDetails_In_IMDB = IMDBpage().goTo_Releasedate_Of_Searched_Movie_In_IMDB_Portal().getText();
		log.info("Grabbed Release Date of searched movie from IMDB portal");
		String releaseDate_In_IMDB = format_Date_as_dd_month_yyyy(releaseDetails_In_IMDB);
		System.out.println("Release Date in IMDB : " + releaseDate_In_IMDB);
		log.info("Release Date in IMDB : " + releaseDate_In_IMDB);

		String Wiki_url = getValueOf("Wiki_url");
		launch_Url(Wiki_url);
		log.info("Launched Wiki url");
		applying_Wait_Implicitly_In_Seconds(5);
		Wikipage().goTo_Wiki_Search().sendKeys(Movie_Name);
		Wikipage().goTo_Wiki_Search().sendKeys(Keys.ENTER);
		log.info("Entered a movie name in Wiki-Search text and clicked on Enter");
		Wikipage().goTo_Searched_Movie_In_Wiki().click();
		log.info("navigated and clicked on the first movie displayed in the search results");
		
		perform_Action().moveToElement(Wikipage().goTo_Country_Text()).perform();
		String countrynName_In_Wiki = Wikipage().goTo_Countryname_Of_Searched_Movie_In_Wiki_Portal().getText();
		log.info("Grabbed Country name of searched movie from Wiki portal");
		System.out.println("Country name in Wiki  : " + countrynName_In_Wiki);
		log.info("Country name in Wiki  : " + countrynName_In_Wiki);
		String releaseDate_In_Wiki = Wikipage().goTo_Releasedate_Of_Searched_Movie_In_Wiki_Portal().getText();
		log.info("Grabbed Release Date of searched movie from Wiki portal");
		System.out.println("Release Date in Wiki : " + releaseDate_In_Wiki);
		log.info("Release Date in Wiki : " + releaseDate_In_Wiki);
		
		if(countryName_In_IMDB.equalsIgnoreCase(countrynName_In_Wiki) )
			
		{
			
			log.info("Country names in both portals matched");
		}
		else {
			log.info("Country names in both portals did not match");
		}
		
        if(releaseDate_In_IMDB.equalsIgnoreCase(releaseDate_In_Wiki) )
			
		{
			
			log.error("Release Dates in both portals matched");
		}
		else {
			log.error("Release Dates in both portals did not match");
		}
		
		
		
		
		Assert.assertTrue(countryName_In_IMDB.equalsIgnoreCase(countrynName_In_Wiki));
		Assert.assertTrue(releaseDate_In_IMDB.equalsIgnoreCase(releaseDate_In_Wiki));

	}

	@AfterTest
	public void teardown() {

		quit_Driver();

	}

}
