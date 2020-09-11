package dukes.birthday;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("capitalize")
@Dependent
@RegisterRestClient
@RegisterClientHeaders
public interface CapitalizeService {

    @GET
    @Path("{word}")
    @Fallback(fallbackMethod = "asIs")
    String capitalize(@PathParam("word") String word);

    default String asIs(String word) {
        return word;
    }
}
