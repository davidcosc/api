package dc.rest.api.controllers;

import dc.rest.api.model.ApiService;
import dc.rest.api.model.ApiServiceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david on 12.07.2018.
 */
@RestController
public class ApiRestController {
    ApiServiceBuilder apiServiceBuilder;

    @Autowired
    public ApiRestController(ApiServiceBuilder apiServiceBuilder) {
        this.apiServiceBuilder = apiServiceBuilder;
    }

    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        if(apiServiceBuilder == null) {
            throw new ServiceNotFoundException();
        }
        ApiService apiService = apiServiceBuilder.getDefaultService().build();
        apiService.execute();
        return ResponseEntity.ok().body(apiService);
    }
}
