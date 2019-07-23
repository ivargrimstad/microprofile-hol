package dukes.birthday;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("birthday")
public class BirthdayResource {

    @Inject
    private BirthDayService birthDayService;

    @Inject
    @RestClient
    private CapitalizeService capitalizeService;

    @GET
    @Path("{name}")
    @Produces(APPLICATION_JSON)
    public Response getBirthdayInfo(@PathParam("name") String name, @QueryParam("date") String date) {

        // 1995-05-23
        final LocalDate birthDate = parse(date, ISO_DATE);
        BirthdayResponse response = new BirthdayResponse(capitalizeService.capitalize(name), birthDayService.calculateDaysToBirthday(birthDate), birthDayService.calculateDaysSinceBirthday(birthDate), birthDayService.age(birthDate));

        return Response.ok(response).build();
    }
}
