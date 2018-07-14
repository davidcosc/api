package dc.rest.api.controllers;

/**
 * Created by david on 14.07.2018.
 */
public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException() {
        super("Could not find service!");
    }
}
