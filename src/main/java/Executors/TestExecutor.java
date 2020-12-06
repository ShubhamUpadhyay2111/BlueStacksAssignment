package Executors;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestExecutor {

	Utils utils;
	WebDriver driver;
	WebDriverWait wait; 


	public void deleteOldFiles() {
		utils = new Utils();
		utils.deleteOldOutputFile();
	}

	public void launchBrowserandGoToHomePage(String homepage) {
		try {
			System.setProperty("webdriver.chrome.driver","D:\\Workspace\\BlueStacks\\Library\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(homepage);
			driver.manage().window().maximize();
		}catch(Exception e) {
			System.out.println("Problem with launching the Home Page. Check the complete explaination of the exception here\n\n" + e);
		}
	}

	public void scrollToBottomOfThePage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.xpath("//p[@class = 'sub-heading']"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
		}catch(Exception e) {
			System.out.println("Problem with Scrolling to the element. Check the complete explaination of the exception here\n\n" + e);
		}

	}

	public void getTheListOfGamesAndProduceExpectedOutput() {
		try {
			TestExecutor testExecutor = new TestExecutor();

			wait = new WebDriverWait(driver,60);
			utils = new Utils();

			int j = 1;

			String columnName = String.format("%-20s%-80s%-110s%-20s%-30s\n", "S No.", "Game Name", "Page Url", "Page Status", "Tournament Count");

			utils.output(columnName);
			utils.output("_________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
			utils.output("\n");

			List<WebElement> elements = driver.findElements(By.xpath("//ul[@class = 'games-list']/li"));
			System.out.println("Number of elements:" +elements.size());


			for (int i = 0; i < elements.size(); i++)
			{
				List<WebElement> element = driver.findElements(By.xpath("//ul[@class = 'games-list']/li"));
				String gameNameTournament = element.get(i).getText();

				String gameName = testExecutor.getGameName(gameNameTournament);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class= 'games-item']/a/figcaption[text()=\"" + element.get(i).getText() +"\"]")));
				driver.findElement(By.xpath("//li[@class= 'games-item']/a/figcaption[text()=\"" + element.get(i).getText() +"\"]")).click();

				String noOfTournaments;


				try {

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= \"count-tournaments\"]")));
					noOfTournaments = driver.findElement(By.xpath("//span[@class= \"count-tournaments\"]")).getText();

				}catch(Exception e) {

					noOfTournaments = "0";

				}
				String output = String.format("%-20s%-80s%-110s%-20s%-30s\n", j++, gameName, driver.getCurrentUrl(), testExecutor.getResponseCode(driver.getCurrentUrl()), noOfTournaments);
				utils.output(output);
				driver.navigate().back();
			}
		}catch(Exception e) {
			System.out.println("Problem in the getting the list and further operations. Check the complete explaination of the exception here\n\n" + e);
		}

	}

	public String getGameName(String gameNameTournament) {

		if (gameNameTournament.contains(" Tournaments")) { 

			String tempWord = " Tournaments"; 
			gameNameTournament = gameNameTournament.replaceAll(tempWord, ""); 
		} 
		return gameNameTournament;
	}

	public int getResponseCode(String url) {

		try {
			URL curreturl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)curreturl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code = connection.getResponseCode();
			return code;
		}catch(Exception e) {
			try {
				Thread.sleep(60000);
				return getResponseCode(url);
			} catch (InterruptedException e1) {
				return getResponseCode(url);
			}
		}
	}

	public void closeAllTheDrivers() {
		try {
			driver.quit();
		}catch(Exception e) {
			System.out.println("Problem with closing the chromedriver instances. Check the complete explaination of the exception here\n\n" + e);
		}
	}

}
