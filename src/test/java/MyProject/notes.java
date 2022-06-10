package MyProject;

public class notes {
    /*
     @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }

}
     */

    /*
    package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class TerminationEmployeeSteps extends CommonMethods {
    @Given("“Admin” user is logged in")
    public void admin_user_is_logged_in() {
       sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
       sendText(login.passwordBox,ConfigReader.getPropertyValue("password"));
       click(login.loginBtn);
    }
    @When("“Admin” selects a specified employee")
    public void admin_selects_a_specified_employee() {

        click(employeeSearchPage.pimOption);
        click(employeeSearchPage.empListOption);

        List<WebElement> employeeData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
        for (WebElement data : employeeData){
            String employeeId = data.getText();
            if (employeeId.equals("28459731")){
                data.click();
                break;
            }
        }
    }

    @When("clicks on Job")
    public void clicks_on_job() {
        List<WebElement> personaDetails = driver.findElements(By.xpath("//ul[@id='sidenav']/li"));
        for (WebElement e : personaDetails){
            String jobDetail = e.getText();
            if (jobDetail.equals("Job")){
                e.click();
                break;
            }
        }
    }

    @When("then clicks on Terminate Employment")
    public void then_clicks_on_terminate_employment() {
       WebElement terminateBtn = driver.findElement(By.id("btnTerminateEmployement"));
       terminateBtn.click();

       WebElement reasons = driver.findElement(By.id("terminate_reason"));
        Select select = new Select(reasons);
        select.selectByVisibleText("Dismissed");

        WebElement terminateDate = driver.findElement(By.id("terminate_date"));
        terminateDate.click();

        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select1 = new Select(monthDD);
        select1.selectByVisibleText("Jun");

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class ='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement date : dates){
            String dateText = date.getText();
            if (dateText.equals("15")){
                date.click();
                break;
            }
        }
        WebElement note = driver.findElement(By.id("terminate_note"));
        note.sendKeys("Terminated due to lack of competence");

        WebElement confirmBtn = driver.findElement(By.id("dialogConfirm"));
        confirmBtn.click();
    }

    @Then("specified employee is terminated")
    public void specified_employee_is_terminated() {
       WebElement termination = driver.findElement(By.id("terminatedDate"));
        Assert.assertTrue(termination.isDisplayed());
    }

}

     */
    /*
    Feature: Termination of specified employee
  @terminate
  Scenario: Termination of specified employee

    Given “Admin” user is logged in
    When “Admin” selects a specified employee
    And clicks on Job
    And then clicks on Terminate Employment
    Then specified employee is terminated
     */
}
