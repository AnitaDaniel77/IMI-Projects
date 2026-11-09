package com.anitadaniel.fraudengine;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication // turns on auto-configuration and finds the components below
public class SpringBootIntroDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroDemo.class, args); // starts Spring and the embedded Tomcat
    }
}

// externalized configuration: the limit comes from application.properties, not from this code
// application.properties line:  fraud.rules.high-amount.threshold=10000
@Component
class LimitReader {

    private final BigDecimal threshold;

    LimitReader(@Value("${fraud.rules.high-amount.threshold:10000}") BigDecimal threshold) {
        this.threshold = threshold; // 10000 is the fallback if the property is missing
    }

    BigDecimal getThreshold() {
        return threshold;
    }
}

// actuator: needs spring-boot-starter-actuator in the pom, then open
// http://localhost:8080/actuator/health  and look for "status":"UP"