package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.EmpMgtDemo_AddEmpPage;
import com.sogeti.automation.test.pageFactory.EmpMgtDemo_LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

import java.util.List;

public class EmpMgtDemoTestSteps extends TestClass {

    TestContext testContext;
    EmpMgtDemo_LoginPage empLoginPage;
    EmpMgtDemo_AddEmpPage empAddPage;

    public EmpMgtDemoTestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        empLoginPage = testContext.getMobilePageObjectManager().getEmpMgtDemo_LoginPage();
        empAddPage= testContext.getMobilePageObjectManager().getEmpMgtDemo_AddEmpPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }



    @Given("^user has installed the EmploymentManagement$")
    public void userHasInstalledTheEmploymentManagement() {
        if(empLoginPage.isMainPageVisible())
        {
            log.info("App installed and launched successfully");
        }


    }

    @When("^enter the (.*) and (.*)")
    public void enterTheUsernameAndPassword(String username, String password) {
        empLoginPage.login(username,password);

    }

    @Then("^user is on the Add Employee Details page$")
    public void userIsOnTheAddEmployeeDetailsPage() {
        boolean flag = empAddPage.isAddEmpButtonVisible();
        Assert.assertTrue(flag,"Add Emp page did not load. LOGIN FAILED");

    }


    @Then("user adds an Employee with all the details")
    public void userAddsAnEmployeeWithAllTheDetails(DataTable testData) {

        List<String> data = testData.transpose().asList(String.class);
        String nameCheck = data.get(0)+" "+data.get(1);
        empAddPage.dataEntryforNewEmployeeAdd(data);
        Assert.assertEquals(empAddPage.verifyDataEntryforNewEmployeeAdd(),nameCheck,"Employee not added");
    }

    @Then("user will signout of the application")
    public void userWillSignoutOfTheApplication() {
        empAddPage.userSignout();
        Assert.assertTrue(empLoginPage.isMainPageVisible(), "Signout is not successful");

    }
}
