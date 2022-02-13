package selelnium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {

		System.setProperty("webdriver.chrome.driver","D:\\GitProjectTesting\\SeleniumProject\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		
		//Verify browser title
		String title = driver.getTitle();
        assertTrue( title.contentEquals("Demo Web Shop") );
        
		//Click on Log in button
		driver.findElement(By.className("ico-login")).click();
		
		//Verify Login button text
		String buttonText = driver.findElement(By.className("ico-login")).getText();
		assertTrue( buttonText.contentEquals("Log in") );
		
		//Enter email id
		driver.findElement(By.id("Email")).sendKeys("acnuser@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("acnuser");
		driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        //Wait 5 seconds
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
