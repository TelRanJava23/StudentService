package telran.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.student.dao.StudentRepositoryImpl;

@Configuration
public class StudentConfiguration {
	
	@Bean
	public StudentRepositoryImpl createStudentRepo() {
		return new StudentRepositoryImpl();
	}

}
