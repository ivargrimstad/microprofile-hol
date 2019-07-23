package dukes.birthday;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Traced
@Path("capitalize")
@Dependent
@RegisterRestClient
public interface CapitalizeService {

    @GET
    @Path("{word}")
    @Fallback(fallbackMethod = "asIs")        
    String capitalize(@PathParam("word") String word);
    
    default String asIs(String word) {
        return word;
    }
}
