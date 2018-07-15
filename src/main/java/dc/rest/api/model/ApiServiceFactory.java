package dc.rest.api.model;

import org.springframework.stereotype.Component;

/**
 * Created by david on 15.07.2018.
 */
@Component
public class ApiServiceFactory {
    public ApiService factoryMethod() {
        return new Service();
    }
}
