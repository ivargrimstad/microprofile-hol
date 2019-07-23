package dukes.birthday;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Traced
@Path("capitalize")
@Dependent
@RegisterRestClient
public interface CapitalizeService {


    @GET
    @Path("{word}")
    String capitalize(@PathParam("word") String word);
}
