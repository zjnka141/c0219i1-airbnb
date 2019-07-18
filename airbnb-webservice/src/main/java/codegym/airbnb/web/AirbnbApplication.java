package codegym.airbnb.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= "codegym.airbnb.dao.repository")
@EnableJpaAuditing()
@SpringBootApplication
@ComponentScan("codegym.airbnb")
@EntityScan("codegym.airbnb.dao.entity")
public class AirbnbApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirbnbApplication.class, args);
    }
}
