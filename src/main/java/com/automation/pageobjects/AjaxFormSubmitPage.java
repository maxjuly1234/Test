/**
 * 
 */
package com.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.TestBase;

/**
 * @author bbanduch This is Ajax Form Submit page.
 */
public class AjaxFormSubmitPage extends TestBase{

	//WebDriver driver;

	public AjaxFormSubmitPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/a") WebElement inputformlink;	
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/ul/li[6]") WebElement ajaxFormSubmit;
	@FindBy(how=How.ID, using="title") WebElement name;
	@FindBy(id="description") WebElement comment;
	@FindBy(how=How.XPATH, using="//input[@id='btn-submit']") WebElement submitButton;
	@FindBy(id="submit-control") WebElement successMsg;
	
	

	public void ajaxFormLaunc() {
		inputformlink.click();
		ajaxFormSubmit.click();

	}

	public void enterAjaxFormDetails() throws InterruptedException {
		name.sendKeys("This should be name of Ajax field");
		comment.sendKeys("A Lead QA Engineer is responsible for all of the activities in the testing of the product, including system and integration testing, test plan review, and best practice improvements. Work with Platform engineering team to plan and develop test suites for a set of products. Maintain and evaluate tests day to day and report problems discovered.  Work with developers to make hard-to-test features more testable for QA. Understand the inner workings of technologies of applications under test. Should be aware that job of a Quality Assurance Engineer is to speak up at any point in the process and test the edge cases of products, and lobby for having problems encountered to get fixed. Ensure the quality of various software products through test planning and execution, serving as a technical point of contact for a product, and assisting the QA Manager drive projects to completion through project planning and management");
		submitButton.click();
		Thread.sleep(5000);
		boolean msgStatus = successMsg.getText().equals(
				"Form submited Successfully!");
		if (msgStatus) {
			System.out.println("Form submited Successfully!");
			APP_LOGS.info("*****************AJAXFormSubmit Flow is over*****************");
		} else {
			System.out.println("Something Wrong");
			APP_LOGS.info("*****************AJAXForm Submit has some issue*****************");
		}
	}

	public void ajaxFormSubmitInValidValidations() {
		submitButton.click();
		String errNameFieldValidation = name.getAttribute("style");
		if (errNameFieldValidation
				.equalsIgnoreCase("border: 1px solid rgb(255, 0, 0);")) {
			System.out.print("Name is Mandate value to Enter");
			APP_LOGS.info("*****************AJAXForm Field Validation is over*****************");
		}

	}

}
