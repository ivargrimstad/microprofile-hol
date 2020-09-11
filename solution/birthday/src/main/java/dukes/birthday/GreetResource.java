
package dukes.birthday;


import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Collections;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ISO_DATE;

/**
 * A simple JAX-RS resource to greet you. Examples:
 * <p>
 * Get default greeting message:
 * curl -X GET http://localhost:8080/greet
 * <p>
 * The message is returned as a JSON object.
 */
@Path("/birthday")
public class GreetResource {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @Inject
    private BirthdayService birthDayService;

    /**
     * Return a worldly greeting message.
     *
     * @return {@link JsonObject}
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getDefaultMessage(@PathParam("name") String name, @QueryParam("date") String date, @HeaderParam("Authorization") String authHeader) {

        WebTarget target = ClientBuilder.newClient().target("http://localhost:8070/capitalize/" + name);
        Response response = target.request().header("Authorization", authHeader).buildGet().invoke();

        final LocalDate birthDate = parse(date, ISO_DATE);
        return JSON.createObjectBuilder()
                .add("name", response.readEntity(String.class))
                .add("daysToBirthday", birthDayService.calculateDaysToBirthday(birthDate))
                .add("daysSinceBirthday", birthDayService.calculateDaysSinceBirthday(birthDate))
                .add("age", birthDayService.age(birthDate))
                .build();
    }
}
