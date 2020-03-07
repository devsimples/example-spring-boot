package br.com.dev.simples.patients.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.dev.simples.patients.model.Patient;
import br.com.dev.simples.patients.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PatientApiIT {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private PatientRepository repository;
	
	@Before
    public void init() {
		repository.save(Patient.builder().firstName("Marcos").build());
		repository.save(Patient.builder().firstName("Maria").build());
    }
	
	@Test
	public void should_get_patients() throws Exception
	{
		mockMvc.perform(get("/patients"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].firstName").value("Marcos"));
//			.andExpect(jsonPath("$[0].firstName", ""));
			//.andExpect(jsonPath("$", hasSize(2)));
			//.andExpect(jsonPath("$[0].firstName", is("Marcos")));

	}
}
