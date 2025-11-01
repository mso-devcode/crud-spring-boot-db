package local.dev.api.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import local.dev.api.rest.model.Person;

@Service
public class PersonService {

    private static final AtomicLong COUNTER = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info("Find one Person");    
        return mockPerson(Integer.parseInt(id));
        
    }

    public List<Person> findAll() {
        logger.info("Find all persons");
        //var persons = new ArrayList<Person>();
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++ ) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;

    }

    public Person save(Person person) {
        logger.info("Saving onr Person");
        return person;
    }

    public Person update(Person person) {
        logger.info("updating one Person");
        return person;
    }

    public void delete(String id) {
        logger.info("deleting one person");

    }

    private Person mockPerson(int id) {
    
        Person person = new Person();
        person.setId(COUNTER.incrementAndGet());
        person.setFirstName("FirstName" + id);
        person.setLastName("LastName" + id);
        person.setAddress("Address " + id);
        person.setGender("Gendar" + id);
        return person;
    }    

}
