package com.udays.personal.projects.dropwizard;

import com.udays.personal.projects.dropwizard.config.DropwizardMovieConfiguration;
import com.udays.personal.projects.dropwizard.entitlements.AppAuthenticator;
import com.udays.personal.projects.dropwizard.entitlements.AppAuthorizer;
import com.udays.personal.projects.dropwizard.entitlements.User;
import com.udays.personal.projects.dropwizard.resource.MovieResource;
import com.udays.personal.projects.dropwizard.service.MovieService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Application class which is entry point for Dropwizard application
 * this marries the application (DropwizardMovieApplication) and configuration (DropwizardMovieConfiguration) with provided yaml config file (DropwizardMovieConfig.yml)
 */
public class DropwizardMovieApplication extends Application<DropwizardMovieConfiguration>{

    /**
     * this is the entry point for jvm to start the DropwizardMovieApplication when we run
     * java -jar command
     * @param args
     * @throws Exception
     */
    public static void main(String... args) throws Exception{
        new DropwizardMovieApplication().run(args);
    }

    /**
     * In order to pickup config.yml from main/resources folder, add bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
     * ideally the config will lie in a separate config project away from application code for easy deployment to change only app config
     * for local testing, I am using yml from main/resources
     * @param bootstrap
     */
    @Override
    public void initialize(Bootstrap<DropwizardMovieConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
    }

    /**
     * run method is abstract in Application class and has to be overriden by classes extending Application, as each application needs to determine how that needs to run
     * @param dropwizardMovieConfiguration
     * @param environment
     * @throws Exception
     */
    @Override
    public void run(DropwizardMovieConfiguration dropwizardMovieConfiguration, Environment environment) throws Exception {
        //register health check class
        DropwizardMovieApplicationHealthCheck healthCheck = new DropwizardMovieApplicationHealthCheck();
        environment.healthChecks().register("DROPWIZARD_HEALTH_CHECK", healthCheck);

        //register OAuth authentication
        environment.jersey().register(
                new AuthDynamicFeature(
                        new OAuthCredentialAuthFilter
                                .Builder<User>()
                                .setAuthenticator(new AppAuthenticator())
                                .setAuthorizer(new AppAuthorizer())
                                .setPrefix("Bearer")
                                .buildAuthFilter()
                )
        );
        environment.jersey().register(RolesAllowedDynamicFeature.class);

        //register resources
        MovieResource movieResource = new MovieResource(new MovieService());
        environment.jersey().register(movieResource);
    }

}
