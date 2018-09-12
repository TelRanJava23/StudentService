package telran.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.student.dao.IStudentRepository;
import telran.student.dto.NotFoundStudentException;
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
		Student newStudent = new Student(student.getId(), student.getName(), student.getPassword());
		return studentRepository.addStudent(newStudent);
	}

	@Override
	public StudentResponseDto deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.removeStudent(id);
		return studentToStudentResponseDto(student);
	}

	@Override
	public StudentDto editStudent(int id, StudentEditDto student) {
		// TODO Auto-generated method stub
		Student studentOld = studentRepository.getStudentById(id);
		if(student.getName() != null) {
			studentOld.setName(student.getName());
		}
		if(student.getPassword() != null) {
			studentOld.setPassword(student.getPassword());
		}
		return studentToStudentDto(studentOld);
	}

	

	@Override
	public StudentResponseDto getStudent(int id) {
		Student student = studentRepository.getStudentById(id);
		return studentToStudentResponseDto(student);
	}

	@Override
	public boolean addScore(int id, ScoreDto score) {
		// TODO Auto-generated method stub
		Student student = studentRepository.getStudentById(id);
		if (student == null) {
			throw new NotFoundStudentException();
		}
		return student.addScore(score.getExamName(), score.getScore());
	}

	private StudentResponseDto studentToStudentResponseDto(Student student) {
		return StudentResponseDto.builder()
				.id(student.getId())
				.name(student.getName())
				.scores(student.getScores())
				.build();
	}
	
	private StudentDto studentToStudentDto(Student studentOld) {
		
		return StudentDto.builder()
				.id(studentOld.getId())
				.name(studentOld.getName())
				.password(studentOld.getPassword())
				.build();
	}
}
