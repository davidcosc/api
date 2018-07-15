package dc.rest.api.model;

import org.springframework.stereotype.Component;

/**
 * Created by david on 15.07.2018.
 */
@Component
public class Service implements ApiService {
    @Override
    public void execute() {
        System.out.println("Service executing!");
    }
}
