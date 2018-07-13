package dc.rest.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david on 12.07.2018.
 */
@RestController
public class ApiRestController {
    Object object;

    public ApiRestController(Object object) {
        this.object = object;
    }

    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        return ResponseEntity.ok().body(object);
    }
}
