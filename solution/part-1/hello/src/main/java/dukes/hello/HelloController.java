package dukes.hello;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    @Produces(TEXT_PLAIN)
    public String sayHello() {
        return "Hello World";
    }
}
