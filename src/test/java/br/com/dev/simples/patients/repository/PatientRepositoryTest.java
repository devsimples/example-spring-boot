package br.com.dev.simples.patients.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dev.simples.patients.Application;
import br.com.dev.simples.patients.model.Patient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PatientRepositoryTest {

	@Autowired
	private PatientRepository repository;

	@Test
	public void should_return_patients_properly_names() {
		save("Marcos");
		save("Maria");
		save("Marcos");

		List<Patient> patientsFound = repository.findByFirstName("Marcos");
		
		assertThat(patientsFound).isNotNull();
		assertThat(patientsFound).size().isEqualTo(2);
	}

	private Patient save(String firstName) {
		return repository.save(Patient.builder().firstName(firstName).build());
	}

}
