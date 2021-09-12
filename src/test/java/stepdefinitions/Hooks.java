package stepdefinitions;

import common_functions.Utils;
import io.cucumber.java.After;

public class Hooks {

	@After
	public void tearDown() {
		Utils.getDriver().quit();
	}
}
