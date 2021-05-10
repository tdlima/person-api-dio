package com.lima.person.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lima.person.dto.request.PersonDTO;
import com.lima.person.dto.response.MessageResponseDTO;
import com.lima.person.exception.PersonNotFoundException;
import com.lima.person.services.PersonService;

import lombok.AllArgsConstructor;


@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return service.createPerson(personDTO);
	}
	
	@GetMapping
	public List<PersonDTO> listAll(){
		return service.listAll();
		
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id)throws PersonNotFoundException {
		return service.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
		return service.updateById(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		service.delete(id);
	}
}
