
package com.sge.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.sge.page.ID001_LoginPage;
import com.sge.page.ID002_HomePage;
import com.sge.page.ID003_AgentesPage;

import properties.ArchivoProperties;

public class IDT002_HomeTest extends ArchivoProperties{	
	
	public IDT002_HomeTest() {
		leerArchivoToBefore();
		leerArchivoToLogin();
		leerArchivoToAgente();
	}
	
	public WebDriver driver;
	
	@Before
	public void abrirBrowser() throws InterruptedException {	
		
		System.setProperty(binariochrome, path); 
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	    driver.get(url);
		
	}
	
	@Test
	 public void ingresarPantallaAltaAgente() throws InterruptedException {
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		//Pasos
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		//Validacion de resultado
		Thread.sleep(2000);
		Assert.assertEquals(agentesPage.tituloPantalla(), tituloEsperadoAgente);	
	}
	
	@After
	public void cerrarBrowser() throws InterruptedException{	
		Thread.sleep(3000);
		driver.quit();		
	}
}
	

