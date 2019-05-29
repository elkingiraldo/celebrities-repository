package com.globant.tests.celebrities.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.tests.celebrities.model.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}
