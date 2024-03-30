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

public class PasageriPage {
	
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

  
//  @Test
//  public void verificaPasageriButon() {
//      WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
//      pasageriButton.click();
//      WebElement titlu = driver.findElement(By.xpath("//h1[contains(text(),'Pasageri')]"));
//  	String text=titlu.getText();
//  	Assert.assertEquals(text,"Pasageri");
//     
//  }
//  
//  @Test
//  public void verificaTabel() {
//	  WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
//      pasageriButton.click();
//	  WebElement table = driver.findElement(By.className("table"));
//	Assert.assertTrue(table.getText().contains("Nume"));
//	Assert.assertTrue(table.getText().contains("Prenume"));
//	Assert.assertTrue(table.getText().contains("NumarDocument"));
//	Assert.assertTrue(table.getText().contains("Email"));
//	Assert.assertTrue(table.getText().contains("Telefon"));
//  }
//  
  @Test
  public void crearePasager() {
	  WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
      pasageriButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement creeazaPasagerNouLink = driver.findElement(By.cssSelector("body > div > main > p > a"));
      creeazaPasagerNouLink.click();
      
      Assert.assertEquals(driver.getCurrentUrl(),"https://localhost:7065/Pasageri/Create");
      WebElement numeInput = driver.findElement(By.id("Pasager_Nume"));
      numeInput.sendKeys("Nume");

      WebElement prenumeInput = driver.findElement(By.id("Pasager_Prenume"));
      prenumeInput.sendKeys("Prenume");

      WebElement numarDocumentInput = driver.findElement(By.id("Pasager_NumarDocument"));
      numarDocumentInput.sendKeys("67593");

      WebElement emailInput = driver.findElement(By.id("Pasager_Email"));
      emailInput.sendKeys("nume.prenume@gmail.com");

      WebElement telefonInput = driver.findElement(By.id("Pasager_Telefon"));
      telefonInput.sendKeys("0700000000");

      WebElement createButton = driver.findElement(By.cssSelector("input.btn.button-stilizat"));
      createButton.click();

      WebElement tabelPasageri = driver.findElement(By.cssSelector("table.table"));
      Assert.assertTrue(tabelPasageri.getText().contains("Nume"));
      Assert.assertTrue(tabelPasageri.getText().contains("Prenume"));
      Assert.assertTrue(tabelPasageri.getText().contains("67593"));
      Assert.assertTrue(tabelPasageri.getText().contains("nume.prenume@gmail.com"));
      Assert.assertTrue(tabelPasageri.getText().contains("0700000000"));

      
  }
  
  @Test
  public void crearePasagerInvalid() {
	  WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
      pasageriButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement creeazaPasagerNouLink = driver.findElement(By.cssSelector("body > div > main > p > a"));
      creeazaPasagerNouLink.click();
      
      Assert.assertEquals(driver.getCurrentUrl(),"https://localhost:7065/Pasageri/Create");
      WebElement numeInput = driver.findElement(By.id("Pasager_Nume"));
      numeInput.sendKeys("Nume123");
      
    
     WebElement prenumeInput = driver.findElement(By.id("Pasager_Prenume"));
     prenumeInput.sendKeys("Prenume123");
    

     WebElement numarDocumentInput = driver.findElement(By.id("Pasager_NumarDocument"));
      numarDocumentInput.sendKeys("numar");


      WebElement emailInput = driver.findElement(By.id("Pasager_Email"));
      emailInput.sendKeys("nume.prenume@nimic.com");
    


      WebElement telefonInput = driver.findElement(By.id("Pasager_Telefon"));
      telefonInput.sendKeys("070abc");
     
      WebElement eroareNume=driver.findElement(By.id("Pasager_Nume-error"));
      Assert.assertEquals(eroareNume.getText(),"Numele trebuie să conțină doar litere.");
      
    
    WebElement eroarePrenume=driver.findElement(By.id("Pasager_Prenume-error"));
    Assert.assertEquals(eroarePrenume.getText(),"Prenumele trebuie să conțină doar litere.");
    WebElement eroareEmail=driver.findElement(By.id("Pasager_Email-error"));
    Assert.assertEquals(eroareEmail.getText(),"Doar adresele de email de la Gmail, Yahoo și iCloud sunt permise.");
    
    driver.navigate().back();
    
      WebElement tabelPasageri = driver.findElement(By.xpath("/html/body/div/main/table"));
      Assert.assertFalse(tabelPasageri.getText().contains("Nume123"));
   
      
  }
  
 @Test
  public void detaliiPasager() {
	  WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
      pasageriButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement detalii=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[3]/td[6]/a[2]"));
      detalii.click();
      
      WebElement nume=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[1]"));
      String numetext=nume.getText();
      
     Assert.assertEquals(numetext, "Nume");
     
     WebElement numeadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[1]"));
     String numeadaugattext=numeadaugat.getText();
     Assert.assertEquals(numeadaugattext, "Nume");
     
     WebElement prenume=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[2]"));
     String prenumetext=prenume.getText();
     
    Assert.assertEquals(prenumetext, "Prenume");
    
    WebElement prenumeadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[2]"));
    String prenumeadaugattext=prenumeadaugat.getText();
    Assert.assertEquals(prenumeadaugattext, "Prenume");
    
    WebElement numardocument=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[3]"));
    String numardocumenttext=numardocument.getText();
    
   Assert.assertEquals(numardocumenttext, "NumarDocument");
   
   WebElement numardocumentadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[3]"));
   String numardocumentadaugatext=numardocumentadaugat.getText();
   Assert.assertEquals(numardocumentadaugatext, "67593");
   
   WebElement email=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[4]"));
   String emailtext=email.getText();
   
  Assert.assertEquals(emailtext, "Email");
  
  WebElement emailadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[4]"));
  String emailadaugattext=emailadaugat.getText();
  Assert.assertEquals(emailadaugattext, "nume.prenume@gmail.com");
  
  WebElement telefon=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[5]"));
  String telefontext=telefon.getText();  
 Assert.assertEquals(telefontext, "Telefon");
 
 WebElement telefonadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[5]"));
 String telefonadaugattext=telefonadaugat.getText();
 Assert.assertEquals(telefonadaugattext, "0700000000");
 
 driver.navigate().back();
 }   
  
  
  @Test
  public void editPasager() {
	  WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
      pasageriButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement edit=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[3]/td[6]/a[1]"));
      edit.click();
      
      Assert.assertTrue(driver.getCurrentUrl().contains("https://localhost:7065/Pasageri/Edit"));
      WebElement numeInput = driver.findElement(By.id("Pasager_Nume"));
      numeInput.clear();
      numeInput.sendKeys("NumeUpdatat");
      
      WebElement submit=driver.findElement(By.xpath("/html/body/div/main/div[1]/div/form/div[6]/input"));
      submit.click();
      WebElement tabelPasageri = driver.findElement(By.xpath("/html/body/div/main/table"));
      Assert.assertTrue(tabelPasageri.getText().contains("NumeUpdatat"));
  }
  
  @Test
  public void stergerePasager() {
	  WebElement pasageriButton = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Pasageri']"));
      pasageriButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      WebElement delete=driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[3]/td[6]/a[3]"));
      delete.click();
      
      Assert.assertTrue(driver.getCurrentUrl().contains("https://localhost:7065/Pasageri/Delete"));
      
      WebElement nume=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[1]"));
      String numetext=nume.getText();
      
     Assert.assertEquals(numetext, "Nume");
     
     WebElement numeadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[1]"));
     String numeadaugattext=numeadaugat.getText();
     Assert.assertEquals(numeadaugattext, "NumeUpdatat");
     
     WebElement prenume=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[2]"));
     String prenumetext=prenume.getText();
     
    Assert.assertEquals(prenumetext, "Prenume");
    
    WebElement prenumeadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[2]"));
    String prenumeadaugattext=prenumeadaugat.getText();
    Assert.assertEquals(prenumeadaugattext, "Prenume");
    
    WebElement numardocument=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[3]"));
    String numardocumenttext=numardocument.getText();
    
   Assert.assertEquals(numardocumenttext, "NumarDocument");
   
   WebElement numardocumentadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[3]"));
   String numardocumentadaugatext=numardocumentadaugat.getText();
   Assert.assertEquals(numardocumentadaugatext, "67593");
   
   WebElement email=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[4]"));
   String emailtext=email.getText();
   
  Assert.assertEquals(emailtext, "Email");
  
  WebElement emailadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[4]"));
  String emailadaugattext=emailadaugat.getText();
  Assert.assertEquals(emailadaugattext, "nume.prenume@gmail.com");
  
  WebElement telefon=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dt[5]"));
  String telefontext=telefon.getText();  
 Assert.assertEquals(telefontext, "Telefon");
 
 WebElement telefonadaugat=driver.findElement(By.xpath("/html/body/div/main/div[1]/dl/dd[5]"));
 String telefonadaugattext=telefonadaugat.getText();
 Assert.assertEquals(telefonadaugattext, "0700000000");
 
 WebElement deletebtn=driver.findElement(By.xpath("/html/body/div/main/div/form/input[2]"));
 deletebtn.click();
 WebElement tabelPasageri = driver.findElement(By.xpath("/html/body/div/main/table"));
 Assert.assertFalse(tabelPasageri.getText().contains("NumeUpdatat"));
 
  }
}
