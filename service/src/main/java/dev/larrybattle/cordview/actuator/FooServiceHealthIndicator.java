package dev.larrybattle.cordview.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// url: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-health
// {
//  "status": "DOWN",
//  "components": {
//    "db": {
//      "status": "UP",
//      "details": {
//        "database": "H2",
//        "validationQuery": "isValid()"
//      }
//    },
//    "fooService": {
//      "status": "DOWN",
//      "details": {
//        "Test": "value",
//        "fun": true
//      }
//    },
//    "ping": {
//      "status": "UP"
//    }
//  }
//}
// TOOD Remove this class
@Component
public class FooServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down()
                .withDetail("Test", "value")
                .withDetail("fun", true)
                .build();
    }
}
