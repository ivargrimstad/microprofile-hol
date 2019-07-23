package dukes.hello;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Health
@ApplicationScoped
public class DukesHealth implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("successful-check")
                .up()
                .withData("Duke", "Rocks!")
                .build();
    }
}
