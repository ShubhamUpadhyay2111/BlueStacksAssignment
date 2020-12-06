package stepDefinitions;

import Executors.TestExecutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BlueStacks {

	TestExecutor testExecutor = new TestExecutor();

	@Given("^We go to the \"([^\"]*)\"$")
	public void we_go_to_the(String homepage){
		
		testExecutor.deleteOldFiles();
		testExecutor.launchBrowserandGoToHomePage(homepage);
		
	}

	@When("^We scroll to the bottom of the page$")
	public void we_scroll_to_the_bottom_of_the_page(){
		
		testExecutor.scrollToBottomOfThePage();

	}

	@Then("^We get the list of the games$")
	public void we_get_the_list_of_the_games(){
		
		testExecutor.getTheListOfGamesAndProduceExpectedOutput();
	}

	@Then("^We close all chrome instances$")
	public void we_close_all_chrome_instances(){
		
		testExecutor.closeAllTheDrivers();
		
	}

}
