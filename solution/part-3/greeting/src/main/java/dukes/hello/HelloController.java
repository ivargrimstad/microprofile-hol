package dukes.hello;

import javax.annotation.security.RolesAllowed;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;


/**
 *
 */
@Path("/hello")
@Singleton
@Metered
public class HelloController {

    @Inject
    @ConfigProperty(name = "greeting")
    private String greeting;

    @Inject
    @RestClient
    private BirthdayService birthdayService;


    @GET
//    @RolesAllowed("protected")
    public String sayHello() {

        BirthdayInfo dukesInfo = birthdayService.getBirthdayInfo("duKe", "1995-05-23");
        return String.format(greeting, dukesInfo.getName(), dukesInfo.getAge(), dukesInfo.getDaysSinceBirthday(), dukesInfo.getDaysToBirthday());
    }
}
