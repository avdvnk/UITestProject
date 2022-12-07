package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.TestDataListener;
import enums.config.ProfileFields;
import helpers.ConfigHelper;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DocsPage;
import pages.MainPage;

@Listeners({TestDataListener.class})
public abstract class BaseTest {

    protected MainPage mainPage;
    protected DocsPage docsPage;

    @BeforeMethod(alwaysRun = true)
    public void initTestEnv() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ProfileFields.enableVNC.getField(),
                ConfigHelper.getProperty(ProfileFields.enableVNC.getField()));
        capabilities.setCapability(ProfileFields.enableVideo.getField(),
                ConfigHelper.getProperty(ProfileFields.enableVideo.getField()));
        capabilities.setCapability(ProfileFields.sessionTimeout.getField(),
                ConfigHelper.getProperty(ProfileFields.sessionTimeout.getField()));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = ConfigHelper.getProperty(ProfileFields.selenoidUrl.getField());
        Configuration.browser = ConfigHelper.getProperty(ProfileFields.browser.getField());
        Configuration.browserVersion = ConfigHelper.getProperty(ProfileFields.browserVersion.getField());
        Configuration.browserSize = ConfigHelper.getProperty(ProfileFields.browserSize.getField());
        Configuration.browserPosition = ConfigHelper.getProperty(ProfileFields.browserPosition.getField());
        Configuration.baseUrl = ConfigHelper.getProperty(ProfileFields.baseUrl.getField());
        String startEndpoint = ConfigHelper.getProperty(ProfileFields.startEndpoint.getField());
        mainPage = Selenide.open(startEndpoint, MainPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
