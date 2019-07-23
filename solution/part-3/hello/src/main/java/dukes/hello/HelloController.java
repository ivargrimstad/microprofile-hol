package dukes.hello;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    @ConfigProperty(name = "greeting")
    private String greeting;

    @Inject
    @RestClient
    private BirthdayService birthdayService;

    @Metered
    @GET
    @Produces(TEXT_PLAIN)
    public String sayHello(@QueryParam("name") @DefaultValue("noname") String name) {

        BirthdayInfo dukesInfo = birthdayService.getBirthdayInfo("duke", "1995-05-23");

        return String.format(greeting, dukesInfo.getName(), dukesInfo.getAge(), dukesInfo.getDaysSinceBirthday(), dukesInfo.getDaysToBirthday());
    }
}
