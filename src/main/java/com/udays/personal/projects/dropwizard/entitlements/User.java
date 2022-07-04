package com.udays.personal.projects.dropwizard.entitlements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Principal;

@NoArgsConstructor
public class User implements Principal {

    @Getter @Setter private int id;
    @Getter @Setter private String username;
    @Getter @Setter private String password;

    /**
     * mandatory override
     * @return
     */
    @Override
    public String getName() {
        return null;
    }
}
