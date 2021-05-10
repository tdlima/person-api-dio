package com.lima.person.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.lima.person.enums.ReleaseStatus;
import com.lima.person.enums.ReleaseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Release {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 120)
	private String description;
	
	@Column(nullable = false)
	private Integer month;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(name = "date_register")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dateRegister;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 7)
	private ReleaseType releaseType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 8)
	private ReleaseStatus releaseStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Person person;
	
}
