package br.com.dev.simples.patients.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.simples.patients.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

	@Override
    public List<Patient> findAll();
	
	public List<Patient> findByFirstName(String firstName);
}
