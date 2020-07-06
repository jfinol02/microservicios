package com.itlg.services.app.itlgrest.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlg.services.app.itlgrest.models.IPersonDao;
import com.itlg.services.app.itlgrest.models.entity.Person;
import com.itlg.services.app.itlgrest.services.IPersonService;

@Service
public class PersonServicesImpl implements IPersonService {
	
	@Autowired
	private IPersonDao personDao;

	@Override
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		
		for( Person p :  personDao.findAll()) {
			if( p.getId() != 2) {
				persons.add(p);
			}
		}
		return persons;
	}

	@Override
	@Transactional
	public Person create(Person person) {
		return personDao.save(person);
	}

	@Override
	@Transactional(readOnly = true)
	public Person findById(Long id) {
		return personDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personDao.deleteById(id);
	}

}
