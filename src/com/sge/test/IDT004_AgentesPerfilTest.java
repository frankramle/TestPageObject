
package com.sge.test;

import java.io.FileNotFoundException;
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
import com.sge.page.ID003_AgentesPage;
import com.sge.page.ID004_AgentesPerfilPage;
import com.sge.page.ID005_AgentesDatosFiscalesPage;
import properties.ArchivoProperties;

public class IDT004_AgentesPerfilTest extends ArchivoProperties{
		
	public WebDriver driver;
	
	public IDT004_AgentesPerfilTest() {
		leerArchivoToBefore();
		leerArchivoToLogin();
		leerArchivoToAgente();
	}
	
	@Before
	public void abrirBrowser() throws InterruptedException {	
		
		System.setProperty(binariochrome, path); 
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	    driver.get(url);   
	}
	
	@Test
	public void verificarCamposObligatorios() throws InterruptedException, FileNotFoundException, IOException {
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);	
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		agentesPage.clickSiguiente();
		//Ver los siguinets mensajes de error
		Thread.sleep(2000);
		Assert.assertTrue(perfilPage.msjCamposObligatorios(msjTipoAgencia, msjDomicilio, msjTelefono));
	}
		
	@Test
	public void visualizarMsjCamposObligatoriosAltaDomicilio() throws InterruptedException, FileNotFoundException, IOException {
			
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.agregarDomicilio("", "", "", "", "", "", "", "", "", "");
		//Ver los siguinets mensajes de error en el pop up alta de domicilio
		Thread.sleep(2000);
		Assert.assertTrue(perfilPage.msjCamposObligatoriosAltaDomicilio(msjCalle, msjCodigoPostal, msjLocalidad, msjProvincia));
	}
	
	@Test
	public void ingresarDatosValidosPopUpDomicilio() throws InterruptedException, FileNotFoundException, IOException{	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.agregarDomicilio(calle, numero, piso, dpto, codigoPostal, entreCalles, barrio, localidad, provincia, informacionAdicional);
		//Ver el registro ingresado
		Thread.sleep(2000);
		Assert.assertEquals(perfilPage.verDomicilioIngresado(provincia), provincia);
	}		
			
	@Test
	public void visualizarMsjCamposObligatoriosAltatelefono() throws InterruptedException, FileNotFoundException, IOException {
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.agregarTelefono("","", "", "");
		//Ver los siguinets mensajes de error en el pop up alta de domicilio
		Thread.sleep(2000);
		Assert.assertTrue(perfilPage.msjCamposObligatoriosAltaTelefono(msjTipoTelefono, msjCodArea, msjNumTelefono));
	}	
	
	@Test
	public void ingresarDatosValidosPopUpTelefono() throws InterruptedException, FileNotFoundException, IOException {	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);	
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.agregarTelefono(tipoTelefono, codigoArea, numTelefono, interno);
		//Ver en la grilla el telefono ingresado
		Thread.sleep(2000);
		Assert.assertTrue(perfilPage.verTelefonoIngresado(numTelefono));
	}
	
	@Test
	public void visualizarMsjCamposObligatoriosAltaEmail() throws InterruptedException, FileNotFoundException, IOException {	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.agregarEmail("", "");
		//Ver los siguinets mensajes de error en el pop up alta de domicilio	
		Thread.sleep(2000);
		Assert.assertTrue(perfilPage.msjCamposObligatoriosAltaEmail(msjTipoEmail, msjEmail));
	}
	
	@Test
	public void ingresarDatosValidosPopUpEmail() throws InterruptedException, FileNotFoundException, IOException {
			
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage (driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage (driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage (driver);	
		//Pasos
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.agregarEmail(tipoEmail, email);	
		//Ver en la grilla el telefono ingresado
		Thread.sleep(2000);
		Assert.assertTrue(perfilPage.verEmailIngresado(email));
	}
	
	@Test
	public void cargarAgentePerfilCompleto() throws FileNotFoundException, IOException, InterruptedException {	
		
		ID001_LoginPage loginPage = new ID001_LoginPage(driver);
		ID002_HomePage homePage = new ID002_HomePage(driver);
		ID003_AgentesPage agentesPage = new ID003_AgentesPage(driver);
		ID004_AgentesPerfilPage perfilPage = new ID004_AgentesPerfilPage(driver);
		ID005_AgentesDatosFiscalesPage datosFiscalesPage = new ID005_AgentesDatosFiscalesPage(driver);
		//Pasos 
		Thread.sleep(2000);
		loginPage.iniciarSesionCon(userOpe, pass);
		homePage.irPantallaAltaAgente();
		agentesPage.ingresarDatosGeneralesCon(cuitValido, nombreFantasia, razonSocial);
		perfilPage.seleccionarTipoAgencia(tipoAgencia);	
		// Pasos - Pop up Domicilio
		perfilPage.agregarDomicilio(calle, numero, piso, dpto, codigoPostal, entreCalles, barrio, localidad, provincia, informacionAdicional);
		// Pop up Telefono
		perfilPage.agregarTelefono(tipoTelefono, codigoArea, numTelefono, interno);		
		// Pop up Email
		perfilPage.agregarEmail(tipoEmail, email);		
		agentesPage.clickSiguiente();
		//Ver titulo de la pestaña siguiente "Datos Fiscales"
		Thread.sleep(3000);
		Assert.assertEquals(datosFiscalesPage.nombrePestaniaSeleccionada(), tituloPestania);		
	}
	
	@After
	public void cerrarBrowser() throws InterruptedException{	
		Thread.sleep(3000);
		driver.quit();
	}
}
	

