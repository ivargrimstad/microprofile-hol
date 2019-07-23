package dukes.hello;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 *
 */
@Path("/hello")
@RequestScoped
public class HelloController {

    @Inject
    @ConfigProperty(name = "greeting")
    private String greeting;

    @Metered
    @GET
    @Produces(TEXT_PLAIN)
    public String sayHello(@QueryParam("name") @DefaultValue("noname") String name) {

        return String.format(greeting, name);
    }
}
