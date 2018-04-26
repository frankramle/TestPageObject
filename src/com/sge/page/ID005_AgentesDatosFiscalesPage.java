
package com.sge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ID005_AgentesDatosFiscalesPage {
	
	protected WebDriver driver;
	public WebDriverWait wait;
	
	private By datosFiscales_titulo_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:tablaDatosFiscalesAltaId_content']/div[1]");	
	private By condicionFiscal_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:messageTipoCondicionFiscalComboId']/div/ul/li/span");	
	private By tipoInscripcionGanancia_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:messageTipoInscGananciasComboId']/div/ul/li/span");	
	private By tipoIIBB_mensaje_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:messageTipoIIBBComboId']/div/ul/li/span");		
	private By condicionFiscal_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:tipoCondicionFiscalComboId_panel']/div");
	private By tipoInscripcionGanancia_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:tipoInscGananciasComboId_panel']/div");
	private By tipoIIBB_tabla_locator  = By.xpath("//*[@id='formAltaAgenteId:tabsPerfilDatosFiscalesId:tipoIIBBComboId_panel']/div");
	
	public ID005_AgentesDatosFiscalesPage(WebDriver driver) {		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
			
	public String nombrePestaniaSeleccionada() throws InterruptedException {
		WebElement datosFiscales_titulo = findElement(datosFiscales_titulo_locator);
		String pestaniaDatosFiscales = datosFiscales_titulo.getText();
		return pestaniaDatosFiscales;
	}
	
	public void seleccionarDatosFiscales(String condicionFiscal, String tipoInscripcionGanancia, String tipoIIBB) throws InterruptedException {
			
		if (condicionFiscal.equalsIgnoreCase("") || tipoInscripcionGanancia.equalsIgnoreCase("") || tipoIIBB.equalsIgnoreCase("")) {	
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("document.getElementById('btnAceptar').click();");		
		}
		else {
			WebElement condicionFiscal_tabla = findElement(condicionFiscal_tabla_locator);
			Thread.sleep(2000);
			WebElement opcion_tr01 = condicionFiscal_tabla.findElement(By.xpath("//tr/td[contains(text(), '"+condicionFiscal+"')]"));
			opcion_tr01.click();
			WebElement tipoInscripcionGanancia_tabla = findElement(tipoInscripcionGanancia_tabla_locator);
			Thread.sleep(2000);
			WebElement opcion_tr02 = tipoInscripcionGanancia_tabla.findElement(By.xpath("//tr/td[contains(text(), '"+tipoInscripcionGanancia+"')]"));
			opcion_tr02.click();
			WebElement tipoIIBB_tabla = findElement(tipoIIBB_tabla_locator);
			Thread.sleep(2000);
			WebElement opcion_tr03 = tipoIIBB_tabla.findElement(By.xpath("//tr/td[contains(text(), '"+tipoIIBB+"')]"));
			opcion_tr03.click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("document.getElementById('btnAceptar').click();");
		}				
	}
	
	public boolean msjCamposObligatorios(String msjCondicionFiscal, String msjTipoInscripcionGanancia, String msjTipoIIBB ) throws InterruptedException {
		String auxMsjCondicionFiscal, auxMsjTipoInscripcionGanancia, auxMsjTipoIIBB;  
		WebElement condicionFiscal_mensaje = findElement(condicionFiscal_mensaje_locator);
		auxMsjCondicionFiscal = condicionFiscal_mensaje.getText();
		WebElement tipoInscripcionGanancia_mensaje = findElement(tipoInscripcionGanancia_mensaje_locator);
		auxMsjTipoInscripcionGanancia  = tipoInscripcionGanancia_mensaje.getText();
		WebElement tipoIIBB_mensaje = findElement(tipoIIBB_mensaje_locator);
		auxMsjTipoIIBB = tipoIIBB_mensaje.getText();
		
		if (auxMsjCondicionFiscal.equalsIgnoreCase(msjCondicionFiscal) && auxMsjTipoInscripcionGanancia.equalsIgnoreCase(msjTipoInscripcionGanancia) && auxMsjTipoIIBB.equalsIgnoreCase(msjTipoIIBB)){
			return true;			
		}
		else {
			return false;
		}
	}
	
	public WebElement findElement(By locator) throws InterruptedException {	
		Thread.sleep(3000);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
