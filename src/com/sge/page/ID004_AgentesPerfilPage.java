
package com.sge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ID004_AgentesPerfilPage {
			
	public WebDriver driver;
	public WebDriverWait wait;
	
	private By perfil_pestania_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId']/ul/li[2]/a");	
	private By tipoAgencia_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:msgTipoAgenciaComboId']/div/ul/li/span");	
	private By domicilio_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:messageDomicilioId']/div/ul/li/span");	
	private By telefono_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:messageTelefonoId']/div/ul/li/span");
	private By tipoAgencia_combobox_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:tipoAgenciaComboId']/div[3]/span");
	private By tipoAgencia_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:tipoAgenciaComboId_panel']/div[2]");
	private By altaDomicilio_icono_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:botonPopupIngresoManualDomicilioId_content']/a/img");	
	private By altaTelefono_icono_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:botonPopupIngresoManualtelefonoId_content']/a/img");	
	private By altaEmail_icono_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:botonPopupIngresoManualEmailId_content']/a/img");	
		
// ----------------------------- Pop up -----------------------------------	
	
	// objetos del pop up Domicilio
	private By calle_mensaje_locator  = By.xpath("//*[@id='formAgenteDomiciloId:messagesCalleId']/span[2]");
	private By codigoPostal_mensaje_locator  = By.xpath("//*[@id='formAgenteDomiciloId:messagesCodigoPostalReqId']/span[2]");
	private By localidad_mensaje_locator  = By.xpath("//*[@id='formAgenteDomiciloId:messageslocalidadId']/span[2]");
	private By provincia_mensaje_locator  = By.xpath("//*[@id='formAgenteDomiciloId:messagesProvinciaId']/span[2]");
	private By calle_textbox_locator  = By.id("formAgenteDomiciloId:calleId");
	private By numero_textbox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:direccionId_content']/div/input");
	private By piso_textbox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:direccionId_content']/div[2]/input");
	private By dpto_textbox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:direccionId_content']/div[3]/input");
	private By codigoPostal_textbox_locator  = By.id("formAgenteDomiciloId:codigoPostalId");
	private By entreCalles_textbox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:domicilioBaseId_content']/div[5]/div/input");
	private By barrio_textbox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:domicilioBaseId_content']/div[6]/div/div/input");
	private By localidad_textbox_locator  = By.id("formAgenteDomiciloId:localidadId");
	private By infoAdicional_textbox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:domicilioBaseId_content']/div[8]/div/input");
	private By provincia_combobox_locator  = By.xpath("//*[@id='formAgenteDomiciloId:provinciaId']/div[3]/span");
	private By domicilio_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:domiciliosId']/div/table");
	private By provinciaLupa_textbox_locator  = By.id("formAgenteDomiciloId:provinciaId_filter");
	
	// objetos del pop up telefono
	private By tipoTelefono_mensaje_locator  = By.xpath("//*[@id='formAltaTelefonoAgenteId:messagesTipoTelefonoId']/div/ul/li/span");
	private By codArea_mensaje_locator  = By.xpath("//*[@id='formAltaTelefonoAgenteId:messagesCodigoAreaId']/div/ul/li/span");
	private By numTelefono_mensaje_locator  = By.xpath("//*[@id='formAltaTelefonoAgenteId:messagesTelefonoId']/div/ul/li/span");	
	private By tipoTelefono_combobox_locator  = By.xpath("//*[@id='formAltaTelefonoAgenteId:tipoTelefonoComboId']/div[3]/span");
	private By tipoTelefono_tabla_locator  = By.xpath("//*[@id='formAltaTelefonoAgenteId:tipoTelefonoComboId_panel']/div/table");								
	private By codigoArea_textbox_locator  = By.id("formAltaTelefonoAgenteId:inputCodigoAreaId");
	private By telefono_textbox_locator  = By.id("formAltaTelefonoAgenteId:inputTelefonoId");
	private By interno_textbox_locator  = By.id("formAltaTelefonoAgenteId:inputInternoId");
	private By telefono_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:telefonosId']/div");
		
	// objetos del pop up Email
	private By tipoEmail_mensaje_locator  = By.xpath("//*[@id='formAltaEmailAgenteId:messagesTipoEmailId']/div/ul/li/span");
	private By email_mensaje_locator  = By.xpath("//*[@id='formAltaEmailAgenteId:messagesEmailInput']/div/ul/li/span");
	private By tipoEmail_combobox_locator  = By.xpath("//*[@id='formAltaEmailAgenteId:tipoEmailComboId']/div[3]/span");
	private By email_textbox_locator  = By.id("formAltaEmailAgenteId:emailInputId");
	private By tipoEmail_tabla_locator  = By.xpath("//*[@id='formAltaEmailAgenteId:tipoEmailComboId_panel']/div");
	private By email_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:emailsId']/div");
	
	public ID004_AgentesPerfilPage(WebDriver driver) {			
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public String nombrePestaniaSeleccionada() throws InterruptedException {	
		WebElement perfil_pestania = findElement(perfil_pestania_locator);
		String pestaniaPerfil = perfil_pestania.getText();
		return pestaniaPerfil;
	}
	
	public boolean msjCamposObligatorios(String msjTipoAgencia, String msjDomicilio, String msjTelefono) throws InterruptedException {	
		String auxMsjTipoAgencia, auxMsjDomicilio, auxMsjTelefono;  
		WebElement tipoAgencia_mensaje = findElement(tipoAgencia_mensaje_locator);
		auxMsjTipoAgencia  = tipoAgencia_mensaje.getText();	
		WebElement domicilio_mensaje = findElement(domicilio_mensaje_locator);
		auxMsjDomicilio  = domicilio_mensaje.getText();
		WebElement telefono_mensaje = findElement(telefono_mensaje_locator);
		auxMsjTelefono = telefono_mensaje.getText();
		
		if (auxMsjTipoAgencia.equalsIgnoreCase(msjTipoAgencia) && auxMsjDomicilio.equalsIgnoreCase(msjDomicilio) && auxMsjTelefono.equalsIgnoreCase(msjTelefono)){
			return true;			
		}
		else {		
			return false;
		}	
	}
	
	public void seleccionarTipoAgencia(String tipoAgencia) throws InterruptedException {	
		WebElement tipoAgencia_combobox = findElement(tipoAgencia_combobox_locator);
		tipoAgencia_combobox.click();
		WebElement tipoAgencia_tabla = findElement(tipoAgencia_tabla_locator);
		WebElement opcion_tr = tipoAgencia_tabla.findElement(By.xpath("//tr/td[contains(text(), '"+tipoAgencia+"')]"));
		opcion_tr.click();
	}
	
	public boolean msjCamposObligatoriosAltaDomicilio(String msjCalle, String msjCodigoPostal, String msjLocalidad, String msjProvincia) throws InterruptedException {	
		String auxMsjCalle, auxMsjCodigoPostal, auxMsjLocalidad, auxMsjProvincia;		
		WebElement calle_mensaje = findElement(calle_mensaje_locator);	
		auxMsjCalle = calle_mensaje.getText();
		WebElement codigoPostal_mensaje = findElement(codigoPostal_mensaje_locator);	
		auxMsjCodigoPostal  = codigoPostal_mensaje.getText();
		WebElement localidad_mensaje = findElement(localidad_mensaje_locator);
		auxMsjLocalidad = localidad_mensaje.getText();
		WebElement provincia_mensaje = findElement(provincia_mensaje_locator);	
		auxMsjProvincia = provincia_mensaje.getText();		
		
		if (auxMsjCalle.equalsIgnoreCase(msjCalle) && auxMsjCodigoPostal.equalsIgnoreCase(msjCodigoPostal) && auxMsjLocalidad.equalsIgnoreCase(msjLocalidad) 
				&& auxMsjProvincia.equalsIgnoreCase(auxMsjProvincia)){
			return true;			
		}
		else {
			return false;
		}			
	}
	
	public boolean msjCamposObligatoriosAltaTelefono(String msjTipoTelefono, String msjCodArea, String msjNumTelefono) throws InterruptedException {
		String auxTipoTelefono, auxMsjCodArea, auxMsjNumTelefono;
		WebElement tipoTelefono_mensaje = findElement(tipoTelefono_mensaje_locator);	
		auxTipoTelefono = tipoTelefono_mensaje.getText();
		WebElement codArea_mensaje = findElement(codArea_mensaje_locator);	
		auxMsjCodArea  = codArea_mensaje.getText();
		WebElement numTelefono_mensaje = findElement(numTelefono_mensaje_locator);	
		auxMsjNumTelefono = numTelefono_mensaje.getText();
		
		if (auxTipoTelefono.equalsIgnoreCase(msjTipoTelefono) && auxMsjCodArea.equalsIgnoreCase(msjCodArea) && auxMsjNumTelefono.equalsIgnoreCase(msjNumTelefono)){
			return true;			
		}
		else {			
			return false;
		}			
	}
	
	public boolean msjCamposObligatoriosAltaEmail(String msjTipoEmail, String msjEmail) throws InterruptedException {	
		String auxTipoEmail, auxMsjEmail;
		WebElement 	tipoEmail_mensaje = findElement(tipoEmail_mensaje_locator);
		auxTipoEmail = tipoEmail_mensaje.getText();
		WebElement 	email_mensaje = findElement(email_mensaje_locator);
		auxMsjEmail  = email_mensaje.getText();
		
		if (auxTipoEmail.equalsIgnoreCase(msjTipoEmail) && auxMsjEmail.equalsIgnoreCase(msjEmail)){
			return true;			
		}
		else {
			return false;
		}			
	}
	
	public void agregarDomicilio(String calle, String numero, String piso, String dpto, String codigoPostal, String entreCalles, 
			String barrio, String localidad, String provincia, String informacionAdicional) throws InterruptedException {
		//click en el icono "+"
		WebElement altaDomicilio_icono = findElement(altaDomicilio_icono_locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", altaDomicilio_icono);
		WebElement calle_textbox = findElement(calle_textbox_locator);	
		calle_textbox.sendKeys(calle);
		WebElement numero_textbox = findElement(numero_textbox_locator);	
		numero_textbox.sendKeys(numero);
		WebElement piso_textbox = findElement(piso_textbox_locator);		
		piso_textbox.sendKeys(piso);
		WebElement dpto_textbox = findElement(dpto_textbox_locator);	
		dpto_textbox.sendKeys(dpto);
		WebElement codigoPostal_textbox = findElement(codigoPostal_textbox_locator);	
		codigoPostal_textbox.sendKeys(codigoPostal);
		WebElement entreCalles_textbox = findElement(entreCalles_textbox_locator);	
		entreCalles_textbox.sendKeys(entreCalles);
		WebElement barrio_textbox = findElement(barrio_textbox_locator);	
		barrio_textbox.sendKeys(barrio);
		WebElement localidad_textbox = findElement(localidad_textbox_locator);	
		localidad_textbox.sendKeys(localidad);
		WebElement provincia_combobox = findElement(provincia_combobox_locator);	
		provincia_combobox.click();
		Thread.sleep(2000);
		WebElement provinciaLupa_textbox = findElement(provinciaLupa_textbox_locator);		
		provinciaLupa_textbox.sendKeys(provincia);
		provinciaLupa_textbox.sendKeys(Keys.ENTER);		
		WebElement infoAdicional_textbox = findElement(infoAdicional_textbox_locator);	
		infoAdicional_textbox.sendKeys(informacionAdicional);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("document.getElementById('formAgenteDomiciloId:btnAceptarAltaDomicilioAgenteId').click();");
	}
	
	public void agregarTelefono(String tipoTelefono, String codigoArea, String telefono, String interno ) throws InterruptedException {	
		//click en el icono "+"
		WebElement altaTelefono_icono = findElement(altaTelefono_icono_locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", altaTelefono_icono);
		
		if (tipoTelefono.equalsIgnoreCase("")) {	
			//NO HACE NADA
		}else {
			WebElement tipoTelefono_combobox = findElement(tipoTelefono_combobox_locator);
			tipoTelefono_combobox.click();
			WebElement tipoTelefono_tabla = findElement(tipoTelefono_tabla_locator);
			Thread.sleep(2000);
			WebElement opcion_tr = tipoTelefono_tabla.findElement(By.xpath("//tr/td[contains(text(), '"+tipoTelefono+"')]"));
			opcion_tr.click();
		}
		
		WebElement codigoArea_textbox = findElement(codigoArea_textbox_locator);	
		codigoArea_textbox.sendKeys(codigoArea);
		WebElement telefono_textbox = findElement(telefono_textbox_locator);	
		telefono_textbox.sendKeys(telefono);
		WebElement interno_textbox = findElement(interno_textbox_locator);	
		interno_textbox.sendKeys(interno);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("document.getElementById('formAltaTelefonoAgenteId:btnAceptarAltaTelefonoAgenteId').click();");
	}
	
	public void agregarEmail(String tipoEmail, String email) throws InterruptedException {	
		//click en el icono "+"
		WebElement altaEmail_icono = findElement(altaEmail_icono_locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", altaEmail_icono);	
		
		if (!(tipoEmail.equalsIgnoreCase(""))) {
			WebElement tipoEmail_combobox = findElement(tipoEmail_combobox_locator);
			tipoEmail_combobox.click();
			WebElement tipoEmail_tabla = findElement(tipoEmail_tabla_locator);
			Thread.sleep(2000);
			WebElement opcion_tr = tipoEmail_tabla.findElement(By.xpath("//tr/td[contains(text(), '"+tipoEmail+"')]"));
			opcion_tr.click();
		}
		
		WebElement email_textbox = findElement(email_textbox_locator);
		email_textbox.sendKeys(email);	
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("document.getElementById('formAltaEmailAgenteId:btnAceptarAltaEmailAgenteId').click();");
	}
	
	public String verDomicilioIngresado(String provincia) throws InterruptedException {	
		String auxProvincia;
		WebElement domicilio_tabla = findElement(domicilio_tabla_locator);
		Thread.sleep(2000);
		WebElement opcion_tr = domicilio_tabla.findElement(By.xpath("//tr/td[4]/span[text()='" + provincia + "']"));
		auxProvincia = opcion_tr.getText();
		System.out.println(auxProvincia);
		return auxProvincia;
	}
	
	public boolean verTelefonoIngresado(String numTelefono) throws InterruptedException {
		String auxNumTelefono;
		WebElement telefono_tabla = findElement(telefono_tabla_locator);
		Thread.sleep(2000);			
		WebElement opcion_tr = telefono_tabla.findElement(By.xpath("//tr/td[2]/span[contains(text(), '" +numTelefono+ "')]"));
		auxNumTelefono = opcion_tr.getText();
		
		if (auxNumTelefono.contains(numTelefono)) {	
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean verEmailIngresado(String email) throws InterruptedException {	
		WebElement email_tabla = findElement(email_tabla_locator);
		Thread.sleep(2000);			
		WebElement opcion_tr = email_tabla.findElement(By.xpath("//tr/td[2]/span[contains(text(), '" +email+ "')]"));
		String auxEmail = opcion_tr.getText();
		
		if (auxEmail.contains(email)) {
			return true;
		}else {
			return false;
		}	
	}
	
	public WebElement findElement(By locator) throws InterruptedException {	
		Thread.sleep(3000);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}


