package completeForm;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import webPages.dropdown;

import static org.testng.Assert.assertEquals;

public class CompleteWebFormTests {

    @Test
    public void CompleteWebFormTests(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='last-name']"));
        WebElement jobTitleField = driver.findElement(By.xpath("//input[@id='job-title']"));

        WebElement selectLevelOfEducation = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
        WebElement selectSex = driver.findElement(By.xpath("//input[@id='checkbox-2']"));

        WebElement selectDatePicker = driver.findElement(By.cssSelector("#datepicker"));
        WebElement submitButton = driver.findElement(By.xpath("//a[@role='button']"));

        WebElement titleWebForm = driver.findElement(By.xpath("//h1[normalize-space()='Complete Web Form']")); //h1[normalize-space()='Complete Web Form']

        //fill web form test
        firstNameField.sendKeys(RandomStringUtils.randomAlphabetic(10));
        lastNameField.sendKeys(RandomStringUtils.randomAlphabetic(10));
        jobTitleField.sendKeys(RandomStringUtils.randomAlphabetic(10));

        //radio button
        selectLevelOfEducation.click();
        selectSex.click();

        //dropdown test
        var dropDownPage = new dropdown(driver);
        String option = "5-9";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();

        //date picker test
        selectDatePicker.sendKeys("1641427200000");

        //verified title of the form
        titleWebForm.getText();
        assertEquals(titleWebForm.getText(), "Complete Web Form", "no title");

        //click submit
        submitButton.click();

    }

}





