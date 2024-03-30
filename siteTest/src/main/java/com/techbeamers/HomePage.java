
package com.techbeamers;

import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

public class HomePage {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.chrome.driver", "C://Users//andre//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://localhost:7065/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verificaZboruriButon() {
        WebElement zboruriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Zboruri']"));
        zboruriButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://localhost:7065/Zboruri");

    }
    
    @Test
    public void verificaBileteButon() {
        WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
        pasageriButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://localhost:7065/Bilete");

    }
    
    @Test
    public void verificaPasageriButon() {
        WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
        pasageriButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://localhost:7065/Pasageri");

    }
    
    @Test
    public void verificaDestinatiiButon() {
        WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
        destinatiiButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://localhost:7065/Destinatii");
    }
    
    @Test
    public void verificareTitlu() {
    	 WebElement homeButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Home']"));
         homeButton.click();
    	WebElement titlu = driver.findElement(By.className("welcome-message"));
    	String text=titlu.getText();
    	Assert.assertEquals(text,"Bine ai venit pe AIR!");
    }
    
    @Test
    public void verificareImagine() {
    	 WebElement homeButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Home']"));
         homeButton.click();
    	WebElement imagine = driver.findElement(By.className("background-image"));
    	String url=imagine.getCssValue(("background-image"));
 
    	Assert.assertTrue(url.contains("plane3"));
    }
    
}
