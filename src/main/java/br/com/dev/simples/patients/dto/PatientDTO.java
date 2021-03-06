package br.com.dev.simples.patients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

	private long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
}
