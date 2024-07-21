package Steps;

import Pages.FindResultsPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



public class StepsAmazon {
    WebDriver driver;
    private String url;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("that staying amazon page_ {string}")
    public void that_staying_amazon_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
    }


    @When("finding product {string}")
    public void finding_product(String produto) {
        // Write code here that turns the phrase above into concrete actions

        HomePage homePage = new HomePage(driver);
        homePage.realizaBusca(produto);
    }

    @Then("page shows price is above {string}")
    public void page_shows_price_is_above(String valorProduto) {
        // Write code here that turns the phrase above into concrete actions
        FindResultsPage resultPage = new FindResultsPage(driver);
        resultPage.clicarProduto();
        Assert.assertEquals(valorProduto, resultPage.retornarValorProduto());
    }

}
