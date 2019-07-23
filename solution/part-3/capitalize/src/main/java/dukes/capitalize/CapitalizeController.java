package dukes.capitalize;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/capitalize")
@ApplicationScoped
@Traced
public class CapitalizeController {

    @GET
    @Path("/{word}")
    public String capitalize(@PathParam("word") String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
