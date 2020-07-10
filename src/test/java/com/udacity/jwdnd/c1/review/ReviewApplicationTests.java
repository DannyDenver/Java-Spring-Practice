package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;

	private String baseUrl;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach() {
		baseUrl = baseUrl = "http://localhost:" + port;
	}

	@Test
	void testUserSignupLoginandSubmitMessage() {
		String username = "daylortaniel";
		String password = "password21";
		String first = "Dan";
		String last = "Tay";

		String message = "Howdy Yall!";

		driver.get(baseUrl + "/signup");

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup(username, password, first, last);

		driver.get(baseUrl + "/login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		ChatPage chatPage = new ChatPage(driver);

		chatPage.enterMessage(message);
		chatPage.selectMessagetype("Shout");
		chatPage.submit();

		ChatMessage sentMessage = chatPage.getFirstMessage();
		assertEquals(username, sentMessage.getUsername());
		assertEquals(message.toUpperCase(), sentMessage.getMessagetext());
	}

}
