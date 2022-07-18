package parallel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class Testparallel {

  private WebDriver driver;

  @Before
  public void init() throws MalformedURLException {


    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "chrome");
    capabilities.setCapability("browserVersion", "103.0");
    capabilities.setCapability("enableVNC", true);
    driver = new RemoteWebDriver(
        URI.create("http://192.168.1.64:4444/wd/hub").toURL(),
        capabilities
    );
  }

  @After
  public void tearDown() {
    if(driver != null) {
      driver.close();
      driver.quit();
    }
  }

 @Test
  public void test9() throws InterruptedException {
    driver.get("https://otus.ru");

    Thread.sleep(3000);
  }

  @Test
  public void test10() throws InterruptedException {
    driver.get("https://otus.ru");

    Thread.sleep(3000);
  }

}
