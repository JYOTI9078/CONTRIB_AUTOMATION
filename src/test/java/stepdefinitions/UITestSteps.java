package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.test.pageFactory.SwagLabsDemo_LoginPage;
import com.sogeti.automation.test.pageFactory.SwagLabsDemo_ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class UITestSteps extends TestClass {

    TestContext testContext;
    SwagLabsDemo_LoginPage swagLabsDemoLoginPage;
    SwagLabsDemo_ProductsPage swagLabsDemo_productsPage;

    public UITestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        swagLabsDemoLoginPage = testContext.getPageObjectManager().getSwagLabsDemo_LoginPage();
        swagLabsDemo_productsPage = testContext.getPageObjectManager().getSwagLabsDemo_ProductsPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    /*@Given("^user opens Konakart application in browser$")
    public void openGoogle() throws InterruptedException {
        Thread.sleep(5000);
    }*/

    @Given("^user logs into SwagLabs portal$")
    public void swagLabsLogin() {
        swagLabsDemoLoginPage.login(Web.UI_USERNAME, Web.UI_PASSWORD);
        Assert.assertTrue(swagLabsDemo_productsPage.isProductsTitleVisible(),
                "Products page did not load. LOGIN FAILED");
    }

    @When("^user is on Products page$")
    public void isProductsPageLoaded() {
        Assert.assertTrue(swagLabsDemo_productsPage.isProductsTitleVisible(),
                "Products page did not load.");
    }

    @Then("^verify that price of (.*) is (.*)")
    public void verifyProductPrice(String productName, String productPrice) {
        String actualProductName = swagLabsDemo_productsPage.getProductName(productName);
        String actualProductPrice = swagLabsDemo_productsPage.getProductPrice(productName);

        Assert.assertEquals(actualProductName, productName, "Actual Product Name does not match expected value.");
        Assert.assertEquals(actualProductPrice, productPrice,
                "Price of product '" + productName + "' does not match expected value.");
    }
}
