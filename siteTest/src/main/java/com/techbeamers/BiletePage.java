package com.techbeamers;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BiletePage {
	
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
	 // driver.quit();
  }

  
  @Test
  public void verificaBileteButon() {
      WebElement bileteButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
      bileteButton.click();
      WebElement titlu = driver.findElement(By.xpath("//h1[contains(text(),'Bilete')]"));
  	String text=titlu.getText();
  	Assert.assertEquals(text,"Bilete");
     
  
  }

  
  @Test
  public void verificaTabel() {
	  WebElement bileteButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
      bileteButton.click();
	  WebElement table = driver.findElement(By.className("table"));
	Assert.assertTrue(table.getText().contains("ID"));
	Assert.assertTrue(table.getText().contains("Clasa"));
	Assert.assertTrue(table.getText().contains("Pret"));
	Assert.assertTrue(table.getText().contains("Zbor"));
	Assert.assertTrue(table.getText().contains("Pasager"));
  }
  
  @Test
  public void creareBilet() {
	  WebElement bileteButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
      bileteButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement creeazaBiletNouLink = driver.findElement(By.cssSelector("body > div > main > p > a"));
      creeazaBiletNouLink.click();
      
      Assert.assertEquals(driver.getCurrentUrl(),"https://localhost:7065/Bilete/Create");
      WebElement zborIDSelect = driver.findElement(By.id("Bilet_ZborID"));
      Select zborIDDropdown = new Select(zborIDSelect);
      zborIDDropdown.selectByValue("1"); 

      WebElement pasagerIDSelect = driver.findElement(By.id("Bilet_PasagerID"));
      Select pasagerIDDropdown = new Select(pasagerIDSelect);
      pasagerIDDropdown.selectByVisibleText("andrei pop"); 

      WebElement clasaInput = driver.findElement(By.id("Bilet_Clasa"));
      clasaInput.sendKeys("Economic"); 

      WebElement pretInput = driver.findElement(By.id("Bilet_Pret"));
      pretInput.sendKeys("500"); 

      WebElement createButton = driver.findElement(By.cssSelector("input[type='submit']"));
      createButton.click();

      WebElement tabelBilete = driver.findElement(By.cssSelector("table.table"));
      Assert.assertTrue(tabelBilete.getText().contains("1"));
      Assert.assertTrue(tabelBilete.getText().contains("andrei pop"));
      Assert.assertTrue(tabelBilete.getText().contains("Economic"));
      Assert.assertTrue(tabelBilete.getText().contains("500"));
      
  }
 

  
 @Test
  public void detaliiPasager() {
	 WebElement bileteButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
     bileteButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement detalii=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[5]/td[6]/a[2]"));
      detalii.click();
      
      WebElement clasa=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[1]"));
      String clasatext=clasa.getText();
      
     Assert.assertEquals(clasatext, "Clasa");
     
     WebElement clasaadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[1]"));
     String clasaadaugattext=clasaadaugat.getText();
     Assert.assertEquals(clasaadaugattext, "Economic");
     
     WebElement pret=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[2]"));
     String prettext=pret.getText();
     
    Assert.assertEquals(prettext, "Pret");
    
    WebElement pretadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[2]"));
    String pretadaugattext=pretadaugat.getText();
    Assert.assertEquals(pretadaugattext, "500,00");
    
    WebElement zbor=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[3]"));
    String zbortext=zbor.getText();
    
   Assert.assertEquals(zbortext, "Zbor");
   
   WebElement zbordocumentadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[3]"));
   String zbordocumentadaugatext=zbordocumentadaugat.getText();
   Assert.assertEquals(zbordocumentadaugatext, "1");
   
   WebElement pasager=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[4]"));
   String pasagertext=pasager.getText();
   
  Assert.assertEquals(pasagertext, "Pasager");
  
  WebElement pasageradaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[4]"));
  String pasageradaugattext=pasageradaugat.getText();
  Assert.assertEquals(pasageradaugattext, "andrei pop");
  
 driver.navigate().back();
 }   
  
  
  @Test
  public void editPasager() {
	   
      WebElement bileteButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
      bileteButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement edit=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[4]/td[6]/a[1]"));
      edit.click();
      
      WebElement pasagerIDSelect = driver.findElement(By.id("Bilet_PasagerID"));
      Select pasagerIDDropdown = new Select(pasagerIDSelect);
      pasagerIDDropdown.selectByVisibleText("claudia"); 
      
      WebElement pretInput = driver.findElement(By.id("Bilet_Pret"));
      pretInput.clear();
      pretInput.sendKeys("600"); 
      
      WebElement submit=driver.findElement(By.xpath("/html/body/div/main/div[1]/div/form/div[5]/input"));
      submit.click();
      WebElement tabelBilete = driver.findElement(By.cssSelector("table.table"));
      Assert.assertTrue(tabelBilete.getText().contains("claudia pop"));
      Assert.assertTrue(tabelBilete.getText().contains("600"));

      
      
  }
  
  @Test
  public void stergereBilet() {
	  WebElement bileteButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Bilete']"));
	     bileteButton.click();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      WebElement delete=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[4]/td[6]/a[3]"));
	      delete.click();
	      
	      WebElement clasa=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[1]"));
	      String clasatext=clasa.getText();
	      
	     Assert.assertEquals(clasatext, "Clasa");
	     
	     WebElement clasaadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[1]"));
	     String clasaadaugattext=clasaadaugat.getText();
	     Assert.assertEquals(clasaadaugattext, "Economic");
	     
	     WebElement pret=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[2]"));
	     String prettext=pret.getText();
	     
	    Assert.assertEquals(prettext, "Pret");
	    
	    WebElement pretadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[2]"));
	    String pretadaugattext=pretadaugat.getText();
	    Assert.assertEquals(pretadaugattext, "600,00");
	    
	    WebElement zbor=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[3]"));
	    String zbortext=zbor.getText();
	    
	   Assert.assertEquals(zbortext, "Zbor");
	   
	   WebElement zbordocumentadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[3]"));
	   String zbordocumentadaugatext=zbordocumentadaugat.getText();
	   Assert.assertEquals(zbordocumentadaugatext, "1");
	   
	   WebElement pasager=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[4]"));
	   String pasagertext=pasager.getText();
	   
	  Assert.assertEquals(pasagertext, "Pasager");
	  
	  WebElement pasageradaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[4]"));
	  String pasageradaugattext=pasageradaugat.getText();
	  Assert.assertEquals(pasageradaugattext, "claudia pop");
	  
 
 WebElement deletebtn=driver.findElement(By.xpath("/html/body/div/main/div/form/input[2]"));
 deletebtn.click();
 
 WebElement tabelBilete = driver.findElement(By.cssSelector("table.table"));
 Assert.assertFalse(tabelBilete.getText().contains("claudia pop"));
 
  }
}
