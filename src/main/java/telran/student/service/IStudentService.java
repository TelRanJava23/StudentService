package telran.student.service;

import telran.student.dto.ScoreDto;
import telran.student.dto.StudentDto;
import telran.student.dto.StudentEditDto;
import telran.student.dto.StudentResponseDto;

public interface IStudentService {
	
	boolean addStudent(StudentDto student);
	
	StudentResponseDto deleteStudent(int id);
	
	StudentDto editStudent(int id, StudentEditDto student);
	
	StudentResponseDto getStudent(int id);
	
	boolean addScore(int id, ScoreDto score);
	
	
	
	

}
