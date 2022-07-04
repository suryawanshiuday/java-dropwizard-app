package com.udays.personal.projects.dropwizard.entitlements;

import io.dropwizard.auth.AuthorizationContext;
import io.dropwizard.auth.Authorizer;

import javax.annotation.Nullable;
import javax.ws.rs.container.ContainerRequestContext;
import java.util.Objects;

/**
 * this is also a skeletal code like AppAuthenticator, can be evolved into full scale OAth implementation
 */
public class AppAuthorizer implements Authorizer<User> {

    /**
     * mandatory override, application will definer their own authorization rules
     * @param user
     * @param s
     * @return
     */
    @Override
    public boolean authorize(User user, String s) {
        //allow any logged in user
        if (Objects.nonNull(user)) {
            return true;
        }
        return false;
    }
}
