package dukes.hello;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Traced
@Path("birthday")
@Dependent
@RegisterRestClient
public interface BirthdayService {

    @GET
    @Path("{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    BirthdayInfo getBirthdayInfo(@PathParam("name") String name, @QueryParam("date") String date);
}