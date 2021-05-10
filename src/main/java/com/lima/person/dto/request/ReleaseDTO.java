package com.lima.person.dto.request;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lima.person.entity.Person;
import com.lima.person.enums.ReleaseStatus;
import com.lima.person.enums.ReleaseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min = 10, max = 120)
	private String description;
	
	@NotEmpty
	private Integer month;
	
	@NotEmpty
	private Integer year;
	
	@NotEmpty
	private Double price;
	
	private LocalDate dateRegister;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private ReleaseType releaseType;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private ReleaseStatus releaseStatus;
	
	@Valid
	private Person person;

}
