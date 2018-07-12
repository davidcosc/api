package dc.rest.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by david on 12.07.2018.
 */
@RestController
public class ApiRestController {
    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        ArrayList<String> services = new ArrayList<String>();
        services.add("service1");
        services.add("service2");
        return ResponseEntity.ok().body(services);
    }
}
