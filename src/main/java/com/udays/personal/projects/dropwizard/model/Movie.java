package com.udays.personal.projects.dropwizard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Getter @Setter private long id;
    @Getter @Setter private String title;
    @Getter @Setter private String director;
    @Getter @Setter private int year;
}
