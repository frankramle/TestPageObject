
package com.sge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ID003_AgentesPage {
		
	public WebDriver driver;
	public WebDriverWait wait;
	
	private By subTituloPantallaAltaAgente_label_locator = By.xpath("//*[@id='formAltaAgenteId:tablaDatosGeneralesId_content']/div[1]");	
	private By tituloPantalla_label_locator = By.xpath("//*[@id='formAltaAgenteId:tablaDatosGeneralesId_content']/div[1]");
	private By cuit_label_locator  = By.xpath("//*[@id='formAltaAgenteId:tablaDatosGeneralesId_content']/div[2]/label");
	private By tipoPersona_label_locator  = By.xpath("//*[@id='formAltaAgenteId:tablaDatosGeneralesId_content']/div[3]/label");
	private By nombreFantasia_label_locator  = By.id("formAltaAgenteId:nombreFantasiaText");
	private By cuit_textbox_locator  = By.id("formAltaAgenteId:cuitId");
	private By razonSocial_label_locator  = By.xpath("//*[@id='formAltaAgenteId:tablaDatosGeneralesId_content']/div[5]/label");
	private By razonSocial_textbox_locator  = By.id("formAltaAgenteId:razonSocialId");
	private By nombreFantasia_textbox_locator  = By.id("formAltaAgenteId:nombreFantasiaId");
	private By cuit_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:messagescuitId']/div/ul/li/span");
	private By tipoPersona_textbox_locator  = By.id("formAltaAgenteId:j_idt51");
	private By nombreFantasia_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:messagesNombreFantasiaId']/div/ul/li/span");
	private By razonSocial_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:messagesRazonSocialId']/div/ul/li/span");
	private By siguiente_button_locator  = By.id("btnSiguiente");
	
	public ID003_AgentesPage(WebDriver driver) {		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public String tituloPantalla() throws InterruptedException {		
		WebElement tituloPantallaAgente_label = findElement(subTituloPantallaAltaAgente_label_locator);
		String titulo = tituloPantallaAgente_label.getText();
		return titulo;
	}
	
	public boolean camposDePantalla(String titulo, String cuit, String tipo, String nombre) throws InterruptedException {	
		WebElement tituloPantalla_label = findElement(tituloPantalla_label_locator);
		String auxTitulo = tituloPantalla_label.getText();
		WebElement cuit_label = findElement(cuit_label_locator);
		String auxCuit  = cuit_label.getText();
		WebElement tipoPersona_label = findElement(tipoPersona_label_locator);
		String auxTipo  = tipoPersona_label.getText();
		WebElement nombreFantasia_label = findElement(nombreFantasia_label_locator);
		String auxNombre = nombreFantasia_label.getText();
				
		if (auxTitulo.equalsIgnoreCase(titulo) && auxCuit.equalsIgnoreCase(cuit) && auxTipo.equalsIgnoreCase(tipo) && auxNombre.equalsIgnoreCase(nombre)){			
			return true;			
		}
		else {	
			return false;
		}
	}
	
	public void ingresarDatosGeneralesCon(String cuit, String nombreFantasia, String razonSocial ) throws InterruptedException {	
		WebElement cuit_textbox = findElement(cuit_textbox_locator);
		Thread.sleep(2000);
		cuit_textbox.sendKeys(cuit);
		cuit_textbox.sendKeys(Keys.TAB);
		
		if (nombreFantasia.equalsIgnoreCase("") || razonSocial.equalsIgnoreCase("")) {	
			
		}else {
			WebElement nombreFantasia_textbox = findElement(nombreFantasia_textbox_locator);
			nombreFantasia_textbox.sendKeys(nombreFantasia);
			WebElement razonSocial_textbox = findElement(razonSocial_textbox_locator);
			razonSocial_textbox.sendKeys(razonSocial);
			WebElement siguiente_button = findElement(siguiente_button_locator);
			siguiente_button.click();	
		}
	}
	
	public String despliegueCampoRazonSocial() throws InterruptedException {	
		WebElement razonSocial_label = findElement(razonSocial_label_locator);
		String razonSocial = razonSocial_label.getText();
		return razonSocial;
	}
	
	public String verMensajeErrorCuit() throws InterruptedException {	
		WebElement cuit_mensaje = findElement(cuit_mensaje_locator);
		String mensaje = cuit_mensaje.getText();
		return mensaje;
	}
	
	public String valorDefectoCampoTipoPersona() throws InterruptedException {	
		WebElement tipoPersona_textbox = findElement(tipoPersona_textbox_locator);
		String valorPorDefacto = tipoPersona_textbox.getAttribute("value");
		return valorPorDefacto;
	}
	
	public boolean camposObligatorios(String msjNombreFantasia, String msjRazonSocial) throws InterruptedException {	
		WebElement siguiente_button = findElement(siguiente_button_locator);
		siguiente_button.click();
		WebElement nombreFantasia_mensaje = findElement(nombreFantasia_mensaje_locator);  
		String auxMsjNombreFantasia = nombreFantasia_mensaje.getText();
		WebElement razonSocial_mensaje = findElement(razonSocial_mensaje_locator);
		String auxMsjRazonSocial  = razonSocial_mensaje.getText();
		
		if (auxMsjNombreFantasia.equalsIgnoreCase(msjNombreFantasia) && auxMsjRazonSocial.equalsIgnoreCase(msjRazonSocial)){
			return true;			
		}
		else {
			return false;
		}
	}
	
	public void clickSiguiente() throws InterruptedException {	
		WebElement siguiente_button = findElement(siguiente_button_locator);
		siguiente_button.click();
	}
	
	public WebElement findElement(By locator) throws InterruptedException {	
		Thread.sleep(3000);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
