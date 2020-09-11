package dukes.capitalize;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 *
 */
 @Path("{word}")
@Singleton
public class HelloController {


    @GET
    public String capitalize(@PathParam("word") String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
