package com.itlg.services.app.itlgrest.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlg.services.app.itlgrest.models.entity.Person;

public interface IPersonDao extends JpaRepository<Person, Long> {

}
