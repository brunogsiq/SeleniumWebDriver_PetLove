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

class Slogan
{
	//Tag necessária para informar ao código que é um teste.
	@Test

	//Inserindo um título ao teste.
	@DisplayName("Validar acesso a tela home e exibição do slogan do site.")

	void sloganTest()
	{
		//Instanciando por padrão o ChromeDriver em uma váriavel.
		WebDriver driver = new ChromeDriver();

		//Configuração do timeOut de 2 segundos.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//Visitando uma página.
		driver.get("https://petlov.vercel.app");

		//Mapeando e buscando um elemento
		WebElement title = driver.findElement(By.cssSelector("h1"));

		// Há necessidade de sempre utilizar timeOut com "esquema de waitUntil"
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());

		//Verificando texto do elemento mapeado anteriormente.
		assertEquals("Conectando corações, mudando vidas!", title.getText(), "Verificando o Slogan da página");

		//Solicitando fechamento do Selenium WebDriver
		driver.close();
	};
};