package local.dev.api.rest.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import local.dev.api.rest.model.Person;
import local.dev.api.rest.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController (PersonService personService) {
        this.service = personService;
    }

    @RequestMapping(value = "/{id}", 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return this.service.findAll();
    }

    @RequestMapping( 
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person save(@RequestBody Person person) {
        return this.service.save(person);
    }

     @RequestMapping( 
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return this.service.update(person);
    }

    @RequestMapping(value = "/{id}", 
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
