package uk.axone.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SigninStepDefn {

    public WebDriver driver;
    @Given("I have to launch the browser")
    public void i_have_to_launch_the_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Given("I navigate to the website")
    public void i_navigate_to_the_website() {
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
    }
    @When("I find and click signin link")
    public void i_find_and_click_signin_link() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
    }
    @When("I enter {string}")
    public void i_enter(String string) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("cheerful.praveena@gmail.com");
    }
    @When("I enter valid {string}")
    public void i_enter_valid(String string) {
       driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Testing@123");
    }
    @When("I click signin button")
    public void i_click_signin_button() {
        driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")).click();
    }
    @Then("verify my {string} appears in TopMenu")
    public void verify_my_appears_in_top_menu(String name) {
        WebElement namedisplay = driver.findElement(By.xpath("//span[contains(text(),name)]"));
        if(namedisplay!=null){
            System.out.println("Displayed name is" + namedisplay.getText());
        }
        else{
            System.out.println("Login unsuccessful");
        }
    }
    @Then("I click sign out on TopMenu")
    public void i_click_sign_out_on_top_menu() {
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")).click();
    }
    @Then("verify signin link appears")
    public void verify_signin_link_appears() {
        WebElement signin = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        if (signin.isDisplayed()){
            System.out.println("Signout successful");
        }
        else{
            System.out.println("Signout unsuccessful");
        }
    }


}
