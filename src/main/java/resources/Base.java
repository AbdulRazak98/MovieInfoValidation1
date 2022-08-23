package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import pageObjects.IMDB_page;
import pageObjects.Wiki_page;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		// place the chrome driver in u r project so dt tmrw when u deploy the project
		// in other machine then user need not download chrome driver seperatley chrome
		// driver is also downloaded automatically

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Utils\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;

	}

	public void launch_Url(String url) {

		driver.get(url);

	}

	public String getValueOf(String property_key) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestData.proerties");

		prop = new Properties();
		prop.load(fis);
		return prop.getProperty(property_key);

	}

	public Actions perform_Action() {

		Actions action = new Actions(driver);

		return action;
	}

	public IMDB_page IMDBpage() {

		IMDB_page imdb = new IMDB_page(driver);
		return imdb;
	}

	public Wiki_page Wikipage() {

		Wiki_page wiki = new Wiki_page(driver);
		return wiki;
	}

	public void applying_Wait_Implicitly_In_Seconds(int seconds) {

		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public String format_Date_as_dd_month_yyyy(String date) {

		String month = date.split(",")[0].split(" ")[0];
		String day = date.split(",")[0].split(" ")[1];
		String year = date.split(",")[1].trim().split(" ")[0];
		String formatted_Date = day + " " + month + " " + year;

		return formatted_Date;
	}

	
	

	public void quit_Driver() {

		driver.quit();

	}

}
