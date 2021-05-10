package com.lima.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lima.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
