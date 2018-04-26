
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
import com.sge.page.ID004_AgentesPerfilPage;
import properties.ArchivoProperties;

public class IDT003_AgentesTest extends ArchivoProperties{
	
	public IDT003_AgentesTest() {		
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
	 public void completitudDePantalla() throws InterruptedException {
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		//Pasos
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();	
		//Ver los siguinets campos de la panttlla Agentes
		Thread.sleep(2000);
		Assert.assertTrue(agentesPage.camposDePantalla(tituloDatosGenerales, cuit_label, tipoPersona_label, nombreFantasia_label));		
	}
	
	@Test
	public void desplegarCampoRazonSocial() throws InterruptedException{	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		//Pasos
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, "", "");
		//Visualizar el campo razon social
		Thread.sleep(2000);
		Assert.assertEquals(agentesPage.despliegueCampoRazonSocial(), razonSocial_label);	
	}
	
	@Test
	public void mensajeCuitInvalido() throws InterruptedException {
	
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitInvalido, "", "");
		//Visualizar el mensaje de error del cuit invalido
		Thread.sleep(3000);
		Assert.assertEquals(agentesPage.verMensajeErrorCuit(), mensajeCuitInvalido);	
	}
	
	@Test
	public void visualizarTipoPersonaPorDefectoYRazonSocial() throws InterruptedException {
	
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);	
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, "", "");
		//Visualizar valor por defecto al ingresra cuit valido
		Thread.sleep(3000);
		Assert.assertEquals(agentesPage.valorDefectoCampoTipoPersona(), valTipoPersona);
		Assert.assertEquals(agentesPage.despliegueCampoRazonSocial(), razonSocial_label);
	}
	
	@Test
	public void verificarCamposObligatorios() throws InterruptedException {
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);		
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, "", "");
		//Ver los siguinets mensajes de error
		Thread.sleep(3000);
		Assert.assertTrue(agentesPage.camposObligatorios(msjNombreFantasia, msjRazonSocial));
	}
	
	@Test
	public void ingresarDatosGeneralesValidos() throws InterruptedException {
			
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);	
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		//Ver titulo de la pestaña
		Thread.sleep(3000);
		Assert.assertEquals(perfilPage.nombrePestaniaSeleccionada(), pestaniaPefil);
	}	
	
	@After
	public void cerrarBrowser() throws InterruptedException{	
		Thread.sleep(3000);
		driver.quit();
	}
}
	
