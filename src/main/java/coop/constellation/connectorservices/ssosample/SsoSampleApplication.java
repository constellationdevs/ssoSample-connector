package coop.constellation.connectorservices.ssosample;

// Required to creater a springboot application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SsoSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoSampleApplication.class, args);
    }
}
