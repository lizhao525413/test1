package Test.exercise;

import java.util.List;

public interface DaoImpl {
	public void addStudent(String Student_code,String name,String gender,int age,int tel);
	public void deleteStudent(String Student_code);
	List<Student> findStudent();
	public void updateStudent(String Student_code,String name);
}
