package com.lima.person.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReleaseStatus {
	
	PENDING("Pending"),
	CANCELED("Canceled"),
	PAID_OUT("Paid Out");
	
	private final String description;
	
}
