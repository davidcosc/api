package dc.rest.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david on 12.07.2018.
 */
@RestController
public class ApiRestController<T> {
    T type;

    public ApiRestController(T type) {
        this.type = type;
    }

    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        if(type == null) {
            throw new ServiceNotFoundException();
        }
        return ResponseEntity.ok().body(type);
    }
}
