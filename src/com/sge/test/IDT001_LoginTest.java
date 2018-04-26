
package com.sge.test;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.sge.page.ID001_LoginPage;
import com.sge.page.ID002_HomePage;
import properties.ArchivoProperties;

public class IDT001_LoginTest extends ArchivoProperties {
	
	public WebDriver driver;

	public IDT001_LoginTest() {		
		leerArchivoToBefore();
		leerArchivoToLogin();
	}
	
	@Before
	public void abrirBrowser() throws InterruptedException {	
		
		System.setProperty(binariochrome, path); //en la variable path esta el robot chromedriver
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	    driver.get (url);
	        
	    /*
	    // para maximizar el browser 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	    driver.get("http://172.16.2.136:8003/sge/pages/login.xhtml");   
	    //
	    */
	}
	
	@Test
	 public void loginCorrecto() throws InterruptedException {	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		
		//Pasos
		loginPage.iniciarSesionCon(userOpe, pass);
		//Validacion de resultado
		Thread.sleep(2000);
		Assert.assertEquals(homePage.nombreUsuario(), tituloEsperado);				
	}
	
	@Test
	 public void loginConUsuarioIncorrecto() throws InterruptedException, IOException, AWTException {	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		//Pasos
		loginPage.iniciarSesionCon(userIncorrecto, pass);
		//Validacion de resultado
		Assert.assertEquals(loginPage.verMensajeErrorSesion(), mensajeLoginIncorrecto);	
	}
	
	@Test
	 public void loginConPassIncorrecto() throws InterruptedException, IOException, AWTException {
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		//Pasos
		loginPage.iniciarSesionCon(userOpe, passIncorrecto);
		//Validacion de resultado
		Assert.assertEquals(loginPage.verMensajeErrorSesion(), mensajeLoginIncorrecto);	
	}
	
	@Test
	 public void mensajeCamposVacios() throws InterruptedException {	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		//Pasos
		loginPage.iniciarSesionCon("", "");
		//Validacion de resultado
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.verMensajeErrorUser(), mensajeUser);		
		Assert.assertEquals(loginPage.verMensajeErrorPass(), mensajePass);	
	}
	
	@After
	public void cerrarBrowser() throws InterruptedException{	 
		Thread.sleep(3000);
		driver.quit();	
	}
}
	

