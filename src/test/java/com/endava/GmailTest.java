package com.endava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by crtanasescu on 7/29/2016.
 */
public class GmailTest {

    static WebDriver webDriver;    //instantiere




    @BeforeClass

    public static void setUp() {       //metoda statica pentru a fi vazuta oriunde pentru ca nu apartine metodei(testului)
        //instanta de motor de cautare
        webDriver = new FirefoxDriver();      //declarare
        //pt a accesa pagina pe care intram
        webDriver.get("https://gmail.com");



        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //facem asteptare deoarece se incarca greu firefox-----wait implicit
        webDriver.manage().window().maximize();    //face fullscreen la ecran
    }



    @Test
    public void testGmail(){

        //verificam ca suntem in campul e-mail cu X-path(unde se introduce e-mail.ul in gmail) --punem intr-o variabila acest camp
        //get the email field
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id=\"Email\"]"));
        emailField.sendKeys("endavaselenium");

        
        //get the next button field
        WebElement nextButton = webDriver.findElement(By.xpath("//input[@id=\"next\"]"));
        nextButton.click();


        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("endavaqa");


        WebElement signIn = webDriver.findElement(By.xpath("//input[@id='signIn']"));
        signIn.click();


        WebElement composeButton = webDriver.findElement(By.xpath("//div[text()='COMPOSE']"));
        composeButton.click();


        WebElement toField = webDriver.findElement(By.xpath("//textarea[@name='to']"));
        toField.sendKeys("endavaselenium@gmail.com");
        toField.sendKeys(Keys.RETURN);   //dam un enter pentru ca apare gmailul scris deasupra subjectului


        WebElement subjectField = webDriver.findElement(By.xpath( "//input[@name='subjectbox']"));
        subjectField.sendKeys("TEST");


        WebElement messageField = webDriver.findElement(By.xpath( "//div[@aria-label='Message Body']"));
        messageField.sendKeys("TEST messaje");

        WebElement pressSend = webDriver.findElement(By.xpath( "//div[@aria-label='Send \u202A(Ctrl-Enter)\u202C']"));
        pressSend.click();

    }



    @AfterClass
    //pentru a inchide fereastra de gmail.
    //tot statica pentru ca e in afara testului
    public static void tearDown(){
        webDriver.close();
    }


}
