package dukes.hello;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    @ConfigProperty(name = "greeting")
    private String greeting;

    @GET
    public String sayHello() {
        return String.format(greeting, "Duke");
    }
}
