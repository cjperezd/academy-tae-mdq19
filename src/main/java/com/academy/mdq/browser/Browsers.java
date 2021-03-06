package com.academy.mdq.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.academy.mdq.driver.capabilities.CapabilitiesReader.CAPABILITIES_READER;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static java.util.Collections.synchronizedList;
import static org.openqa.selenium.remote.DesiredCapabilities.*;

/**
 * Browsers supports getting the capabilities per platform.
 * It uses {@link io.github.bonigarcia.wdm.WebDriverManager} to download the version of the getDriver binary.
 */
public enum Browsers implements GetCapabilities {

  CHROME {
    public Capabilities getCapabilities() {
      if (!BINARY_DOWNLOADED.contains(CHROME)) {
        chromedriver().setup();
        BINARY_DOWNLOADED.add(CHROME);
      }

      DesiredCapabilities capabilities = DesiredCapabilities.chrome();

      Map<String, Object> extraCapabilities = CAPABILITIES_READER.readCapabilities("chrome.properties");
      String[] arguments = String.valueOf(extraCapabilities.get(ARGUMENTS)).split(",");
      extraCapabilities.remove(ARGUMENTS);
      extraCapabilities.forEach((key, value) -> capabilities.setCapability(key, value));

      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.merge(capabilities);
      for (String argument : arguments) {
        chromeOptions.addArguments("--" + argument);
      }

      return chromeOptions;
    }
  },
  FIREFOX {
    @Override
    public Capabilities getCapabilities() {
      if (!BINARY_DOWNLOADED.contains(FIREFOX)) {
        firefoxdriver().setup();
        BINARY_DOWNLOADED.add(FIREFOX);
      }
      return firefox();
    }
  },
  IEXPLORER {
    @Override
    public Capabilities getCapabilities() {
      if (!BINARY_DOWNLOADED.contains(IEXPLORER)) {
        iedriver().setup();
        BINARY_DOWNLOADED.add(IEXPLORER);
      }
      InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
      internetExplorerOptions.merge(internetExplorer());
      return internetExplorerOptions;
    }
  },
  ANDROID {
    @Override
    public Capabilities getCapabilities() {
      MutableCapabilities capabilities = new MutableCapabilities();
      Map<String, Object> extraCapabilities = CAPABILITIES_READER.readCapabilities("android.properties");
      extraCapabilities.forEach((key, value) -> capabilities.setCapability(key, value));
      return capabilities;
    }
  },
  IPHONE {
    @Override
    public Capabilities getCapabilities() {
      return iphone();
    }
  };

  private static final String ARGUMENTS = "arguments";

  private static final List<Browsers> BINARY_DOWNLOADED = synchronizedList(new ArrayList());

}
