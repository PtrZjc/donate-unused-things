package pl.zajacp.donateunusedthings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DonateUnusedThingsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DonateUnusedThingsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DonateUnusedThingsApplication.class);
    }

}
