
package local.dev.api.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import local.dev.api.rest.exception.ResourceNotFoundException;
import local.dev.api.rest.model.Person;
import local.dev.api.rest.repository.PersonRepository;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());
    
    private final PersonRepository repository;

    public PersonService(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    public Person findById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        logger.info("Find one Person");    
        return  this.repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not Found item with this Id"));
        
    }

    public List<Person> findAll() {
        logger.info("Find all persons");
        //var persons = new ArrayList<Person>();
        return this.repository.findAll();

    }

    @SuppressWarnings("null")
    public Person save(Person person) {
        logger.info("Saving onr Person");
        return this.repository.save(person);
    }

    public Person update(Person person) {
        logger.info("updating one Person");
        
        @SuppressWarnings("null")
        Person entity = this.repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Not Found item with this Id"));
        
        entity.setId(person.getId());    
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return this.repository.save(entity);
    }

    @SuppressWarnings("null")
    public void delete(Long id) {
        logger.info("deleting one person");

            if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Person person = this.repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not Found item with this Id"));
        this.repository.delete(person);
    }
  
}
