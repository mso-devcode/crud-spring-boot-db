package local.dev.api.rest.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //@RequestMapping(value = "/{id}", 
    @GetMapping(value = "/{id}", 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    //@RequestMapping(method = RequestMethod.GET,
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return this.service.findAll();
    }

    //@RequestMapping(
    @PostMapping( 
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person save(@RequestBody Person person) {
        return this.service.save(person);
    }

     //@RequestMapping(
     @PutMapping( 
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return this.service.update(person);
    }

    //@RequestMapping(value = "/{id}", 
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();     
    }

    
}
