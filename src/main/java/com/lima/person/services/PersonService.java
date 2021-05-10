package com.lima.person.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.person.dto.request.PersonDTO;
import com.lima.person.dto.response.MessageResponseDTO;
import com.lima.person.entity.Person;
import com.lima.person.exception.PersonNotFoundException;
import com.lima.person.maper.PersonMapper;
import com.lima.person.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private PersonRepository repository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	//Método para criação de pessoa
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		Person personSave = personMapper.toModel(personDTO);
		
		Person savedPerson = repository.save(personSave);		
		return createMessageResponse(savedPerson.getId()," The person with id was created successfully!");
	}
	
	//Método para listagem geral
	public List<PersonDTO> listAll(){		
		List<Person> allPeople = repository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//Listagem por id
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExist(id);		
		return personMapper.toDTO(person);
	}
	 //Exclusão de pessoa por id
	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExist(id);
		repository.deleteById(id);
	}
	
	//Atualização de pessoa
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExist(id);
		
		Person personUpdate = personMapper.toModel(personDTO);
		
		Person updatePerson = repository.save(personUpdate);		
		return createMessageResponse(updatePerson.getId(), " The person with id was updated successfully!");
	}
	
	//Criação de mensagem de confirmação para criação ou atualização de pessoas
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(id + message)
				.build();
	}
	
	//Verifica se o id existe 
	private Person verifyIfExist(Long id) throws PersonNotFoundException {
		return repository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
	}
}
