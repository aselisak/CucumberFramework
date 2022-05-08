package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {
    @Then("user verifies all the dashboard tabs")
    public void user_verifies_all_the_dashboard_tabs(DataTable dataTable) {

        List<String> expectedTabs =  dataTable.asList();

        List<String> actualTabs = new ArrayList<>();

        for (WebElement ele:dash.dashBoardTabs){
            actualTabs.add(ele.getText());
        }
        System.out.println(actualTabs);//coming from my execution
       System.out.println(expectedTabs);//coming from my feature file
       // Assert.assertEquals(actualTabs,expectedTabs);
        //if assertions is passed it will not give you any information and will execute our code
        //if assertion is fails, then the test case is failed and stops the execution
        Assert.assertTrue(expectedTabs.equals(actualTabs));


    }
}
