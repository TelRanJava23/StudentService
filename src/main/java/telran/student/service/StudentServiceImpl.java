package telran.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.student.dao.IStudentRepository;
import telran.student.dto.ScoreDto;
import telran.student.dto.StudentDto;
import telran.student.dto.StudentEditDto;
import telran.student.dto.StudentResponseDto;
import telran.student.entities.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public boolean addStudent(StudentDto student) {
		Student newStudent = new Student(student.getId(), 
				student.getName(), student.getPassword());
		return studentRepository.addStudent(newStudent);
	}

	@Override
	public StudentResponseDto deleteStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto editStudent(int id, StudentEditDto student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDto getStudent(int id) {
		Student student = studentRepository.getStudentById(id);
		StudentResponseDto studentResponse = new StudentResponseDto();
		studentResponse.setId(student.getId());
		studentResponse.setName(student.getName());
		studentResponse.setScores(student.getScores());
		return studentResponse;
	}

	@Override
	public boolean addScore(int id, ScoreDto score) {
		// TODO Auto-generated method stub
		return false;
	}

}
