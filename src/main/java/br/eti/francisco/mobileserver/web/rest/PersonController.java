package br.eti.francisco.mobileserver.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.eti.francisco.mobileserver.model.Person;
import br.eti.francisco.mobileserver.repository.PersonDao;


@RestController
@RequestMapping(value="/person")
public class PersonController {

	@Autowired
	private PersonDao personDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> person() {
		List<Person> target = new ArrayList<>();
		personDao.findAll().forEach(target::add);
		return target;
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person person(@PathVariable int id) {
        return personDao.findOne(id);
    }

    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public List<Person> person(@PathVariable String name) {
        return personDao.listByName("%" + name + "%");
    }

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Person person) {
		personDao.save(person);
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		personDao.delete(id);
		return ResponseEntity.ok(null);
	}

}
