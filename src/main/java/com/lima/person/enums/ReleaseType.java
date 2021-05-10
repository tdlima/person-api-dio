package com.lima.person.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReleaseType {
	
	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private final String description;
	
}
