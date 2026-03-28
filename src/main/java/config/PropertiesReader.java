package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesReader {

    public static String read(String property) {

        Properties properties = new Properties();

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("src/test/resources/test.resources");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(property);

    }
}
