
package com.sge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ID001_LoginPage {
		
	public WebDriver driver;
	public WebDriverWait wait;
	
	// repositorio de objetos localizados
	private By usuario_textbox_locator  = By.id("formLogin:myLogin:username");
	private By pass_textbox_locator  = By.id("formLogin:myLogin:password");
	private By ingresar_button_locator  = By.id("formLogin:myLogin:loginButton");
	private By loginIncorrecto_mensaje_locator  = By.xpath("//*[@id='formLogin:j_idt18']/div/ul/li/span");
	private By user_mensaje_locator  = By.xpath("//*[@id='formLogin:j_idt18']/div/ul/li[1]/span");
	private By password_mensaje_locator  = By.xpath("//*[@id='formLogin:j_idt18']/div/ul/li[2]/span");
	
	public ID001_LoginPage(WebDriver driver) {	
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
			
	public void iniciarSesionCon(String usuario, String password) throws InterruptedException {
		WebElement usuario_textbox = findElement(usuario_textbox_locator);
		usuario_textbox.clear();		
		usuario_textbox.sendKeys(usuario);
		WebElement pass_textbox = findElement(pass_textbox_locator);
		pass_textbox.clear();
		pass_textbox.sendKeys(password);		
		WebElement ingresar_button = findElement(ingresar_button_locator);
		ingresar_button.click();
	}
	
	public String verMensajeErrorSesion() throws InterruptedException {
		WebElement loginIncorrecto_mensaje = findElement(loginIncorrecto_mensaje_locator);
		String mensaje = loginIncorrecto_mensaje.getText();
		return mensaje;
	}
	
	public String verMensajeErrorUser() throws InterruptedException {
		WebElement user_mensaje = findElement(user_mensaje_locator);
		String mensaje = user_mensaje.getText();
		return mensaje;
	}
	
	public String verMensajeErrorPass() throws InterruptedException {
		WebElement password_mensaje = findElement(password_mensaje_locator);
		String mensaje = password_mensaje.getText();	
		return mensaje;
	}
	
	 private WebElement findElement(By locator) throws InterruptedException {
		 Thread.sleep(2000);
		 return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}	
}

