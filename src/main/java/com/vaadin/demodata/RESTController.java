package com.vaadin.demodata;


import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "Demo data REST end point. Check out /people, /countries or /languages";
    }

    @GET
    @Path("/people")
    @Produces({MediaType.APPLICATION_JSON})
    public Map<String, Object> getRandomPeople(@QueryParam("index") @DefaultValue("0") Integer index,
                                               @QueryParam("count") @DefaultValue("50") Integer count) {
        List<Person> personList = this.people.getPeople();


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
    @Path("/languages")
    @Produces({MediaType.APPLICATION_JSON})
    public List<String> getLanguages() {
        return languages.getLanguages();
    }
}
