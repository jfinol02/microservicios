package com.itlg.services.app.itlgrest.controllres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlg.services.app.itlgrest.models.entity.Person;
import com.itlg.services.app.itlgrest.services.IPersonService;

@RestController
@RequestMapping("/api")
public class PresonController {
	
	@Autowired
	private IPersonService presonServices;
	
	@GetMapping("/persons")
	public List<Person> list() {
		return presonServices.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person findOne(@PathVariable(name = "id") Long id) {
		return presonServices.findById(id);
	}
	
	@PostMapping("/persons")
	public Person create(@RequestBody Person person) {
		return presonServices.create(person);
	}
	
	@PutMapping("/persons/{id}")
	public Person update(@RequestBody Person person, @PathVariable(name = "id") Long id) {
		
		Person upadtePerson = presonServices.findById(id);
		upadtePerson.setFirstName(person.getFirstName());
		upadtePerson.setLastName(person.getLastName());
		upadtePerson.setEmail(person.getEmail());
		upadtePerson.setCreateAt(person.getCreateAt());
		return presonServices.create(upadtePerson);
	}
	
	@DeleteMapping("/persons/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		presonServices.delete(id);
	}
}
