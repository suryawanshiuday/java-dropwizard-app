package com.udays.personal.projects.dropwizard.entitlements;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import java.util.Optional;

/**
 * this is a skeleton authenticator class, this can be used to evolve into full scale OAuth mechanism
 */
public class AppAuthenticator implements Authenticator<String, User> {

    /**
     * mandatory override, application will define their own authentication rules
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Optional<User> authenticate(String token) throws AuthenticationException {
        if ("test_token".equals(token)) {
            return Optional.of(new User());
        }
        return Optional.empty();
    }
}
