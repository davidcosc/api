package dc.rest.api.model;

import org.springframework.stereotype.Component;

/**
 * Created by david on 15.07.2018.
 */
@Component
public class ApiServiceBuilder {
    private ApiService apiService;

    public ApiServiceBuilder getDefaultService() {
        apiService = new Service();
        return this;
    }

    public ApiService build() {
        return apiService;
    }
}
