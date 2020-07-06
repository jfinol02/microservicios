package com.itlg.services.app.itlgrest.services;

import java.util.List;

import com.itlg.services.app.itlgrest.models.entity.Person;

public interface IPersonService {

	public List<Person> findAll();

	public Person create(Person person);

	public Person findById(Long id);

	public void delete(Long id);
}
