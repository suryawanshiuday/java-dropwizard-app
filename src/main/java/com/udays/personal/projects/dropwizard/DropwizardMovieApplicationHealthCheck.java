package com.udays.personal.projects.dropwizard;

import com.codahale.metrics.health.HealthCheck;

public class DropwizardMovieApplicationHealthCheck extends HealthCheck {

    /**
     * HealthCheck.check method is abstract and required by extending classes to implement, apps should determine their own health check rules
     * @return
     * @throws Exception
     */
    @Override
    protected Result check() throws Exception {
        //TODO: implement based on whether we can get movies from db
        return Result.healthy();
    }
}
