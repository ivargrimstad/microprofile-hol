package dukes.capitalize;


import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"protected"})
public class CapitalizeRestApplication extends Application {
}
