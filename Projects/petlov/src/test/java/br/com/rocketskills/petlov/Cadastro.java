package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class Cadastro
{
	//Tag necessária para informar ao código que é um teste.
	@Test

	//Inserindo um título ao teste.
	@DisplayName("Validar acesso a tela de cadastro de ponto de doação.")

	void cadastroTest()
	{		
		//Instanciando por padrão o ChromeDriver em uma váriavel.
		WebDriver driver = new ChromeDriver();

		//Configuração do timeOut de 2 segundos.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//Visitando uma página.
		driver.get("https://petlov.vercel.app/signup");

		//Mapeando e buscando um elemento
		WebElement title = driver.findElement(By.cssSelector("h1"));

		// Há necessidade de sempre utilizar timeOut com "esquema de waitUntil"
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());

		//Verificando texto do elemento mapeado anteriormente.
		assertEquals("Cadastro de ponto de doação", title.getText(), "Verificando o título da página");

		//Solicitando fechamento do Selenium WebDriver
		driver.close();
	};
};