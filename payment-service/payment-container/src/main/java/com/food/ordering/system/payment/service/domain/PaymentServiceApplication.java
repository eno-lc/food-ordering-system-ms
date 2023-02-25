package com.food.ordering.system.payment.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Enis Halilaj
 * @since 1.0.0
 * @EnableJpaRepositories is used to enable JPA repositories in the application. In this case, it is used to enable JPA repositories in the data access layer.
 * @EntityScan is used to scan JPA entities. In this case, it is used to scan JPA entities in the data access layer.
 * @SpringBootApplication is used to enable auto-configuration of the Spring Application Context.
 * @SpringBootApplication is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes.
 */

@EnableJpaRepositories(basePackages = "com.food.ordering.system.payment.service.dataaccess")
@EntityScan(basePackages = "com.food.ordering.system.payment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
