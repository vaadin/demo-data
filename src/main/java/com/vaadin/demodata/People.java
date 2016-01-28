package com.vaadin.demodata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class People {

    public static final int NUM_PEOPLE = 200;
    private List<Person> people = new ArrayList<>(NUM_PEOPLE);

    @Autowired
    Names names;

    @Autowired
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
