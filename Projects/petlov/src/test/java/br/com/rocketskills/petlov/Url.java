package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Url {

    @Test
    @DisplayName("Validar acesso à URL do projeto.")
    void urlTest() {
        // Instanciando o ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Configuração do timeout implícito de 2 segundos
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Visitando a página
        driver.get("https://petlov.vercel.app");

        // Capturando e imprimindo a URL atual
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL atual: " + currentUrl);

        // Verificando se a URL atual é a URL esperada
        assertTrue(currentUrl.equals("https://petlov.vercel.app"), 
                   "A URL atual não corresponde à URL esperada!");

        // Fechando o navegador
        driver.quit();
    }
}
