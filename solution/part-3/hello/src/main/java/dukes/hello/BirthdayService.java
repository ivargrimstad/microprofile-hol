package dukes.hello;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("birthday")
@Dependent
@RegisterRestClient
public interface BirthdayService {

    @GET
    @Path("{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "simpleInfo")
    @Retry(delay = 1_000L, maxRetries = 30)
    BirthdayInfo getBirthdayInfo(@PathParam("name") String name, @QueryParam("date") String date);

    default BirthdayInfo simpleInfo(String name, String date) {
        return new BirthdayInfo(name, -1, -1, -1);
    }
}