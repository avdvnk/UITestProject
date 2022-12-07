package helpers;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.Properties;

@Slf4j
public class ConfigHelper {

    private static final Properties profileProperties = new Properties();
    private static final String rootDirectory = System.getProperty("user.dir");
    private static final String profileDirPath = Path.of("src", "main",
            "resources", "profiles").toString();
    private static final String profileName = getProfileName();
    private static final String profileFilePath = Path.of(rootDirectory, profileDirPath, profileName).toString();

    private static String getProfileName() {
        return System.getProperty("profile") == null ? "default.properties" : System.getProperty("profile");
    }
    public static void initEnvProperties() {
        try (FileInputStream profileInputStream = new FileInputStream(profileFilePath)) {
            profileProperties.load(profileInputStream);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Profile initialization failed!");
        }
    }

    public static synchronized String getProperty(String key) {
        if (profileProperties.isEmpty()) initEnvProperties();
        String value = profileProperties.getProperty(key, "");
        if (value.isEmpty()) {
            log.warn("Can't get value for key: '{}'. Trying to use default value", key);
        } else log.info("Property key: '{}', property value: '{}'", key, value);
        return value;
    }
}
