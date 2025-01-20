package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class PontoDoacao
{
	String nome;	
	String email;
	String cep;
	Integer numero;
	String complemento;
	String pets;

	public PontoDoacao(String nome, String email, String cep, Integer numero, String complemento, String pets)
	{
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.pets = pets;
	}
}

class Preenche
{
	WebDriver driver;

	@BeforeEach
	void start()
	{
		//Instanciando por padrão o ChromeDriver em uma váriavel.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Configuração do timeOut de 2 segundos.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	};

	@AfterEach
	void finish()
	{
		//Solicitando fechamento do Selenium WebDriver
		driver.close();
	};

	@Test
	@DisplayName("Validar cadastro de ponto de doação.")
	void cadastroPontoDoacao()
	{		
		

		//Visitando uma página.
		driver.get("https://petlov.vercel.app/signup");

		//Mapeando e buscando um elemento
		WebElement title = driver.findElement(By.cssSelector("h1"));

		// Há necessidade de sempre utilizar timeOut com "esquema de waitUntil"
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());

		WebElement name = driver.findElement(By.cssSelector("input[placeholder='Nome do ponto de doação']"));
		name.sendKeys("Gato Zoeiro");

		WebElement email = driver.findElement(By.cssSelector("input[placeholder='E-mail']"));
		email.sendKeys("gatozoeiro@gmail.com");

		WebElement cep = driver.findElement(By.cssSelector("input[placeholder='CEP']"));
		cep.sendKeys("11050031");

		WebElement cepButton = driver.findElement(By.cssSelector("input[value='Buscar CEP']"));
		cepButton.click();

		WebElement rua = driver.findElement(By.cssSelector("input[placeholder='Rua']"));
			// Configura uma espera para garantir que o elemento esteja visível
			wait.until(d -> rua.isDisplayed());
			// Obtém o valor do campo de entrada
			String valorRua = rua.getAttribute("value");
			// Verifica se o valor contém 'Rua Alexandre Herculano'
			assertTrue(valorRua.contains("Rua Alexandre Herculano"),
			"O valor do campo não contém o texto esperado 'Rua Alexandre Herculano'");

		WebElement numero = driver.findElement(By.cssSelector("input[placeholder='Número']"));
		numero.sendKeys("109");

		WebElement complemento = driver.findElement(By.cssSelector("input[placeholder='Complemento']"));
		complemento.sendKeys("1910");

		WebElement bairro = driver.findElement(By.cssSelector("input[placeholder='Bairro']"));
			// Obtém o valor do campo de entrada
			String valorBairro = bairro.getAttribute("value");
			// Verifica se o valor contém 'Rua Alexandre Herculano'
			assertTrue(valorBairro.contains("Gonzaga"));

		WebElement cidadeEstado = driver.findElement(By.cssSelector("input[placeholder='Cidade/UF']"));
			// Obtém o valor do campo de entrada
			String valorCidadeEstado = cidadeEstado.getAttribute("value");
			// Verifica se o valor contém 'Rua Alexandre Herculano'
			assertTrue(valorCidadeEstado.contains("Santos/SP"));

		driver.findElement(By.xpath("//span[text()=\"Cachorros\"]/..")).click();

		driver.findElement(By.className("button-register")).click();

		WebElement result = driver.findElement(By.cssSelector("#sucess-page p"));

		// Há necessidade de sempre utilizar timeOut com "esquema de waitUntil"
		Wait<WebDriver> waitResult = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> result.isDisplayed());
		
		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
		assertEquals(target, result.getText(), "Verificando a mensagem de sucesso.");
	};
};