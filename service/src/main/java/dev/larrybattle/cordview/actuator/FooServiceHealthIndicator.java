package dev.larrybattle.cordview.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

// $ curl -I -L http://localhost:8080/actuator/health/fooService
//  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
//                                 Dload  Upload   Total   Spent    Left  Speed
//  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0HTTP/1.1 412
//Content-Type: application/vnd.spring-boot.actuator.v3+json
//Transfer-Encoding: chunked
//Date: Thu, 20 Aug 2020 04:45:26 GMT

// TOOD Remove this class
@Component
public class FooServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Map<String, Object> props = new HashMap<>();
        props.put("propA", "valueA");
        props.put("isPropB", true);
        props.put("timeForPropB", new Date());

        return Health.status("TEST_FAILED")
                .withDetails(props)
                .build();
    }

}
