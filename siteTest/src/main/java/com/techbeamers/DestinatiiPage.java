package com.techbeamers;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DestinatiiPage {
	
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
  public void verificaPasageriButon() {
      WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
      destinatiiButton.click();
      WebElement titlu = driver.findElement(By.xpath("//h1[contains(text(),'Destinatii')]"));
  	String text=titlu.getText();
  	Assert.assertEquals(text,"Destinatii");
     
  }
  
  @Test
  public void verificaTabel() {
	  WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
      destinatiiButton.click();
	  WebElement table = driver.findElement(By.className("table"));
	Assert.assertTrue(table.getText().contains("ID"));
	Assert.assertTrue(table.getText().contains("Nume"));
	Assert.assertTrue(table.getText().contains("Tara"));
	Assert.assertTrue(table.getText().contains("Aeroport"));
  }
  
  @Test
  public void creareDestinatie() {
	  WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
      destinatiiButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement creeazaDestinatieNouaLink = driver.findElement(By.cssSelector("body > div > main > p > a"));
      creeazaDestinatieNouaLink.click();
      
      Assert.assertEquals(driver.getCurrentUrl(),"https://localhost:7065/Destinatii/Create");
      WebElement numeInput = driver.findElement(By.id("Destinatie_Nume"));
      numeInput.sendKeys("munte");

      WebElement taraInput = driver.findElement(By.id("Destinatie_Tara"));
      taraInput.sendKeys("Nepal");

      WebElement aeroportInput = driver.findElement(By.id("Destinatie_Aeroport"));
      aeroportInput.sendKeys("Dolpa");

      WebElement createButton = driver.findElement(By.cssSelector("input.btn.button-stilizat"));
      createButton.click();

      WebElement tabel = driver.findElement(By.cssSelector("table.table"));
      Assert.assertTrue(tabel.getText().contains("munte"));
      Assert.assertTrue(tabel.getText().contains("Nepal"));
      Assert.assertTrue(tabel.getText().contains("Dolpa"));

      
  }
  
  @Test
  public void creareDestinatieInvalida() {
	  WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
      destinatiiButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement creeazaDestinatieNouaLink = driver.findElement(By.cssSelector("body > div > main > p > a"));
      creeazaDestinatieNouaLink.click();
      
      Assert.assertEquals(driver.getCurrentUrl(),"https://localhost:7065/Destinatii/Create");
      WebElement numeInput = driver.findElement(By.id("Destinatie_Nume"));
      numeInput.sendKeys("3423");

      WebElement taraInput = driver.findElement(By.id("Destinatie_Tara"));
      taraInput.sendKeys("243");
      
      WebElement aeroportInput = driver.findElement(By.id("Destinatie_Aeroport"));
      aeroportInput.sendKeys("Dolpa");

      WebElement eroareNume=driver.findElement(By.id("Destinatie_Nume-error"));
      Assert.assertEquals(eroareNume.getText(),"Numele trebuie să conțină doar litere.");
      
      WebElement eroareTara=driver.findElement(By.id("Destinatie_Tara-error"));
      Assert.assertEquals(eroareTara.getText(),"Tara trebuie să conțină doar litere.");

      driver.navigate().back();

      WebElement tabel = driver.findElement(By.cssSelector("table.table"));
      Assert.assertFalse(tabel.getText().contains("3423"));
   

      
  }
 @Test
  public void detaliiDestinatie() {
	 WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
     destinatiiButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement detalii=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[3]/td[5]/a[2]"));
      detalii.click();
      
      WebElement nume=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[1]"));
      String numetext=nume.getText();
      
     Assert.assertEquals(numetext, "Nume");
     
     WebElement numeadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[1]"));
     String numeadaugattext=numeadaugat.getText();
     Assert.assertEquals(numeadaugattext, "munte");
     
     WebElement tara=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[2]"));
     String taratext=tara.getText();
     
    Assert.assertEquals(taratext, "Tara");
    
    WebElement taraadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[2]"));
    String taraadaugattext=taraadaugat.getText();
    Assert.assertEquals(taraadaugattext, "Nepal");
    
    WebElement aeroport=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[3]"));
    String aeroporttext=aeroport.getText();
    
   Assert.assertEquals(aeroporttext, "Aeroport");
   
   WebElement aeroportadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[3]"));
   String aeroportadaugatext=aeroportadaugat.getText();
   Assert.assertEquals(aeroportadaugatext, "Dolpa");
 
 driver.navigate().back();
 }   
  
  
  @Test
  public void editPasager() {
	  WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
      destinatiiButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement edit=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[3]/td[5]/a[1]"));
      edit.click();
     

      WebElement aeroportInput = driver.findElement(By.id("Destinatie_Aeroport"));
      aeroportInput.clear();
      aeroportInput.sendKeys("DolpaUpdated");
      
      WebElement submit=driver.findElement(By.xpath("/html/body/div/main/div[1]/div/form/div[4]/input"));
      submit.click();
      WebElement tabel = driver.findElement(By.cssSelector("table.table"));
      Assert.assertTrue(tabel.getText().contains("DolpaUpdated"));
  }
  
  @Test
  public void stergerePasager() {
	  WebElement destinatiiButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Destinatii']"));
	     destinatiiButton.click();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement delete=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[3]/td[5]/a[3]"));
      delete.click();
      
      WebElement nume=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[1]"));
      String numetext=nume.getText();
      
     Assert.assertEquals(numetext, "Nume");
     
     WebElement numeadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[1]"));
     String numeadaugattext=numeadaugat.getText();
     Assert.assertEquals(numeadaugattext, "munte");
     
     WebElement tara=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[2]"));
     String taratext=tara.getText();
     
    Assert.assertEquals(taratext, "Tara");
    
    WebElement taraadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[2]"));
    String taraadaugattext=taraadaugat.getText();
    Assert.assertEquals(taraadaugattext, "Nepal");
    
    WebElement aeroport=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[3]"));
    String aeroporttext=aeroport.getText();
    
   Assert.assertEquals(aeroporttext, "Aeroport");
   
   WebElement aeroportadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[3]"));
   String aeroportadaugatext=aeroportadaugat.getText();
   Assert.assertEquals(aeroportadaugatext, "DolpaUpdated");
 
 WebElement deletebtn=driver.findElement(By.xpath("/html/body/div/main/div/form/input[2]"));
 deletebtn.click();
 WebElement tabel = driver.findElement(By.cssSelector("table.table"));
 Assert.assertFalse(tabel.getText().contains("DolpaUpdated"));
 
  }
}
