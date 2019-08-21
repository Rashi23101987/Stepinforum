package com.titan.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;

@Test
public class MasterClass {

		WebDriver driver;
		
		public void testMethod() throws InterruptedException {

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\salam\\Downloads\\chromedriver_win32\\chromedriver.exe");
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\Resources\\chromedriver.exe");
		 */
		  driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	        driver.manage().window().maximize();
	    	
		driver.get("https://www.youtube.com");
		driver.findElement(By.xpath("//*[@id='container']//input[@id='search']")).sendKeys("step-inforum");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.findElement(By.xpath("//*[@id='channel-title']/span[text()='STeP-IN Forum']")).click();
		driver.findElement(By.xpath("//*[@id='tabsContent']/paper-tab[2]/div")).click();
		
		
		String VideoName;
		
	            RequestSpecification requestSpec = new RequestSpecBuilder().build();
	            RestAssured.baseURI = "http://54.169.34.162:5252";
	            RequestSpecification httpRequest = RestAssured.given();
	            Response response = httpRequest.get("/video");
	            
	            // Retrieve the body of the Response
	            ResponseBody body = response.getBody();
	            VideoName = body.asString();
	            
	            // By using the ResponseBody.asString() method, we can convert the  body
	            // into the string representation.
	            System.out.println("Response Body is: " + VideoName);
	        	JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		         
	          
		        
	            WebElement VideoNameElement=driver.findElement(By.xpath("//*[@id='video-title' and text()='"+VideoName+"']"));
				   
	            if(VideoNameElement.isDisplayed()==false) {
	            	jse6.executeScript("window.scrollBy(0,1500)", ""); 
	            }
	           
	        		Thread.sleep(5000);
	         	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", VideoNameElement);
	          	
	         	Thread.sleep(5000);
	         
	         	VideoNameElement.click();
	           
	            
	            
	            
	            
	            
	            
		}
		
	}

