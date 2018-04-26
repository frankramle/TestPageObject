
package com.sge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ID002_HomePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	private By headerAdministracion_menu_locator  = By.xpath("//*[@id='formMainMenu:j_idt26']/ul/li[1]/a/span");
	private By opcionAgente_locator  = By.xpath("//*[@id='formMainMenu:j_idt26']/ul/li[1]/ul/table/tbody/tr/td[1]/ul[1]/li[2]/a/span");
	private By user_label_locator  = By.id("logUser");
	private By agente_pestania_locator  = By.id("imprimibleFormId:altaAgenteLinkId");
		
	public ID002_HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);	
	}
		
	public String nombreUsuario() throws InterruptedException {	
		WebElement user_label = findElement(user_label_locator);
		String titulo = user_label.getText();
		return titulo;
	}
	
	public void irPantallaAltaAgente() throws InterruptedException {			
		WebElement headerAdministracion_menu = findElement(headerAdministracion_menu_locator);
		headerAdministracion_menu.click();
		WebElement opcionAgente = findElement(opcionAgente_locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", opcionAgente);
		WebElement agente_pestania = findElement(agente_pestania_locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agente_pestania);
	}	
	
	public WebElement findElement(By locator) throws InterruptedException {	
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}

