package com.vaadin.demodata;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {

    public static final int NUM_PEOPLE = 200;
    private List<Person> people = new ArrayList<>(NUM_PEOPLE);

    @Inject
    Names names;

    @Inject
    Addresses addresses;


    @PostConstruct
    public void init() {
        System.out.println("Created new People");
        for (int i = 0; i < NUM_PEOPLE; i++) {
            people.add(new Person(names.getRandomFirstName(), names.getRandomLastName(), addresses.getRandomAddress()));
        }
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }
}
