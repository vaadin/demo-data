package com.vaadin.demodata;


import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Singleton
@Path("/1.0")
public class RESTController {

    @Inject
    People people;
    @Inject
    Countries countries;
    @Inject
    Languages languages;

    @GET
    @Path("/")
    @Produces({MediaType.TEXT_PLAIN})
    public String root() {
        return "Demo data REST end point. Check out /people, /countries, /filtered-countries or /languages";
    }

    @GET
    @Path("/people")
    @Produces({MediaType.APPLICATION_JSON})
    public Map<String, Object> getRandomPeople(
            @QueryParam("index") @DefaultValue("0") Integer index,
            @QueryParam("count") @DefaultValue("50") Integer count,
            @QueryParam("filters[firstName]") String firstNameFilter,
            @QueryParam("filters[lastName]") String lastNameFilter,
            @QueryParam("orders[]") final List<String> orders) {
        List<Person> personList = new ArrayList<Person>();

        for (Person person : people.getPeople()) {
            if (firstNameFilter != null && !person.getFirstName().toUpperCase().contains(firstNameFilter.toUpperCase())) continue;
            if (lastNameFilter != null && !person.getLastName().toUpperCase().contains(lastNameFilter.toUpperCase())) continue;
            personList.add(person);
        }

        Collections.reverse(orders);
        for (String sortOrder : orders) {
            switch (sortOrder) {
                case "firstName asc":
                    personList.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
                    break;
                case "firstName desc":
                    personList.sort((o1, o2) -> o2.getFirstName().compareTo(o1.getFirstName()));
                    break;
                case "lastName asc":
                    personList.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
                    break;
                case "lastName desc":
                    personList.sort((o1, o2) -> o2.getLastName().compareTo(o1.getLastName()));
                    break;
            }
        }

        int size = personList.size();
        int end = index + count;

        if (end > size) {
            end = size;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("size", size);
        result.put("result", personList.subList(index, end));

        return result;
    }

    @GET
    @Path("/countries")
    @Produces({MediaType.APPLICATION_JSON})
    public List<String> getCountries() {
        return countries.getCountries();
    }

    @GET
    @Path("/filtered-countries")
    @Produces({MediaType.APPLICATION_JSON})
    public Map<String, Object> getCountries(
            @QueryParam("index") @DefaultValue("0") Integer index,
            @QueryParam("count") @DefaultValue("50") Integer count,
            @QueryParam("filter") String countryFilter) {
        List<String> countryList = new ArrayList<String>();

        for (String country : countries.getCountries()) {
            if (countryFilter != null && !country.toUpperCase().contains(countryFilter.toUpperCase())) continue;
            countryList.add(country);
        }

        int size = countryList.size();
        int end = index + count;

        if (end > size) {
            end = size;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("size", size);
        result.put("result", countryList.subList(index, end));

        return result;
    }

    @GET
    @Path("/languages")
    @Produces({MediaType.APPLICATION_JSON})
    public List<String> getLanguages() {
        return languages.getLanguages();
    }
}
