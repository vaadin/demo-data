package com.vaadin.demodata;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RESTController {

    @Autowired
    People people;
    @Autowired
    Countries countries;
    @Autowired
    Languages languages;

    @RequestMapping("/")
    public String root(){
        return "Demo data REST end point. Check out /people, /countries or /languages";
    }

    @RequestMapping("/people")
    public Map<String, Object> getRandomPeople(@RequestParam(value = "index", required = false, defaultValue = "0") int index,
                                               @RequestParam(value = "count", required = false, defaultValue = "50") int count) {
        List<Person> personList = this.people.getPeople();
        int size = personList.size();
        int end = index + count;

        if (end > size) {
            end = size;
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("size", size);
        result.put("result", personList.subList(index, end));

        return result;
    }

    @RequestMapping("/countries")
    public List<String> getCountries() {
        return countries.getCountries();
    }

    @RequestMapping("/languages")
    public List<String> getLanguages() {
        return languages.getLanguages();
    }
}
