package page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import common_functions.Utils;

public class FlipkartPage {
	Utils util = new Utils();

	public FlipkartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement input_search;

	@FindBy(how = How.XPATH, using = "//ul[@role='listbox']")
	private WebElement searchList;

	@FindBy(how = How.XPATH, using = "//li//div[@role='option']//div[1]//span")
	private WebElement listItems;

	@FindBy(how = How.XPATH, using = "(//input[@value='Google Search'])[1]")
	private WebElement button_search;

	@FindBy(how = How.XPATH, using = "//h3[text()='Flipkart']")
	private WebElement link_flipkart;

	@FindBy(how = How.XPATH, using = "//button[text()='✕']")
	private WebElement button_cross;

	@FindBy(how = How.XPATH, using = "(//div[@class='_1YokD2 _3Mn1Gg'])[2]")
	private WebElement frame;

	@FindBy(how = How.XPATH, using = "//a//span[text()='COMPARE']")
	private WebElement button_compare;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'col col-3')]//a")
	private WebElement list_items;

	@FindBy(how = How.XPATH, using = "//div[@class='row EcigTC']//a//img")
	private WebElement images;

	@FindBy(how = How.XPATH, using = "//*[@id='container']//div[1]//li[1]/button[text()='ADD TO CART']")
	private WebElement button_addToCart;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'My Cart')]")
	private WebElement button_addToMyCart;

	@FindBy(how = How.XPATH, using = "//button[text()='GO TO CART']")
	private WebElement button_gotToCart;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter delivery pincode']")
	private WebElement text_pincode;

	@FindBy(how = How.XPATH, using = "//div//span[text()='Check']")
	private WebElement button_check;

	@FindBy(how = How.XPATH, using = "(//*[@id='container']//div[5])[2]")
	private WebElement webMessage;

	@FindBy(how = How.XPATH, using = "(//div//img[contains(@src,'data:image')])[2]")
	private WebElement click_Dropdown;

	public void launchUrlAndVerify(String browser) {
		util.launchUrl(browser);
	}

	public void enterInSearch(final String value) {
		util.verifyElementPresent(input_search);
		util.enterText(value, input_search);
		util.waitForPageload();
	}

	public void getSuggestions() {
		try {
			printSuggestions();
		} catch (Exception e) {
			printSuggestions();
		}
	}

	public void printSuggestions() {
		util.waitForPageload();
		util.verifyElementPresent(searchList);
		util.verifyElementPresent(listItems);
		List<WebElement> listItems = searchList.findElements(By.xpath("//li//div[@role='option']//div[1]//span"));
		System.out.println("Google Suggestions: -");
		for (int i = 0; i < listItems.size(); i++) {
			String result = listItems.get(i).getText();
			System.out.println(result);
		}
	}

	public void clickOnSearch() {
		util.clickOnWebElement(button_search);
	}

	public void clickOnFlipkart() {
		util.verifyElementPresent(link_flipkart);
		util.clickOnWebElement(link_flipkart);
	}

	public void closeLoginPopup() {
		try {
			util.verifyElementPresent(button_cross);
			util.clickOnWebElement(button_cross);
		} catch (Exception e) {
			System.out.println("No popup present.");
		}
	}

	public void goToItem(final String value) {
		WebElement selectItem = util.findElementOfList("//a//img[@alt='" + value + "']");
		util.moveToElement(selectItem);
		util.waitForPageload();
	}

	public void chooseAppliancesItem(final String value) {
		WebElement selectItem = util.findElementOfList("//div//a[text()='" + value + "']");
		util.moveToElement(selectItem);
		util.waitForPageload();
	}

	public void clickAppliancesItem(final String value) {
		WebElement selectItem = util.findElementOfList("//div//a[text()='" + value + "']");
		selectItem.click();
		util.waitForPageload();
	}

	public void selectCompareCheckBox(final int itemNo) {
		util.verifyElementPresent(frame);
		WebElement selectCheckbox = frame.findElement(By.xpath("(//span//input[@type='checkbox'])[" + itemNo + "]"));
		util.moveToElementUsingJS(selectCheckbox);
		util.waitForPageload();
	}

	public void clickCompareButton() {
		util.verifyElementPresent(button_compare);
		util.clickOnWebElement(button_compare);
	}

	public void printProductNameandPrice() {
		util.verifyElementPresent(list_items);
		List<WebElement> listItems1 = util.findElementsOfList("//div[contains(@class,'col col-3')]//a");
		List<WebElement> listItems2 = util
				.findElementsOfList("//div[contains(@class,'col col-3')]//div[contains(@class,'_25')]//div[1]");
		System.out.println("Product Names & Prices: -");
		for (int i = 0; i < listItems1.size(); i++) {
			String result1 = listItems1.get(i).getText();
			String result2 = listItems2.get(i).getText();
			System.out.println(result1 + ": " + result2);
		}
	}

	public void addToCart() {
		util.verifyElementPresent(images);
		List<WebElement> listItems1 = util.findElementsOfList("//div[@class='row EcigTC']//a//img");
		for (int i = 0; i < listItems1.size(); i++) {
			if (i != listItems1.size()) {
				WebElement iconImg = util.findElementOfList("(//div[@class='row EcigTC']//a//img)[" + (i + 1) + "]");
				iconImg.click();
				util.waitForPageload();
				util.verifyElementPresent(button_addToCart);
				util.clickOnWebElement(button_addToCart);
				util.verifyElementPresent(button_addToMyCart);
			}
			if (i != listItems1.size() - 1) {
				util.navigateBack();
				util.waitForPageload();
				util.verifyElementPresent(button_gotToCart);
				util.navigateBack();
				util.waitForPageload();
				util.verifyElementPresent(images);
			}
		}
	}

	public void enterPinCode(final String pin) {

		util.verifyElementPresent(text_pincode);
		util.moveToElementAndClick(text_pincode);
		util.enterText(pin, text_pincode);
		util.waitForPageload();
	}

	public void clickCheckButton() {
		util.verifyElementPresent(button_check);
		util.clickOnWebElement(button_check);
		util.waitForPageload();
	}

	public void clickOnDropdown() {
		util.waitForPageload();
		util.verifyElementPresent(click_Dropdown);
		util.moveToElementAndClick(click_Dropdown);
	}

	public void printMessage() {
		System.out.println("Message: ");
		util.getTextFromWebElement(webMessage);
	}
}
