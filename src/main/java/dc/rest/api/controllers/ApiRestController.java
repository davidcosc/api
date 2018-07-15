package dc.rest.api.controllers;

import dc.rest.api.model.ApiService;
import dc.rest.api.model.ApiServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david on 12.07.2018.
 */
@RestController
public class ApiRestController {
    private ApiServiceFactory apiServiceFactory;

    @Autowired
    public ApiRestController(ApiServiceFactory apiServiceFactory) {
        this.apiServiceFactory = apiServiceFactory;
    }

    @GetMapping("/services")
    public ResponseEntity<?> getServices() {
        if(apiServiceFactory == null) {
            throw new ServiceNotFoundException();
        }
        ApiService apiService = apiServiceFactory.factoryMethod();
        apiService.execute();
        return ResponseEntity.ok().body(apiService);
    }
}
