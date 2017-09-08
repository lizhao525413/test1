package Test.exercise;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Test test =new Test();
		test.addTest();
		/*test.deleteTest();*/
		/*test.findTest();*/
		/*test.updateTest();*/
	}
	//测试添加数据的方法
	public void addTest() {
		StudentDao s1= new StudentDao();
		s1.addStudent("xa005", "lizhao", "男", 21, 33434342);
	}
	//测试删除数据的方法
	public void deleteTest() {
		StudentDao s1= new StudentDao();
		s1.deleteStudent("xa002");
	}
	//测试查询数据的方法
	public void findTest() {
		StudentDao s1= new StudentDao();
		List<Student> sList = s1.findStudent ();
		System.out.println("学生id\t学生编号\t学生姓名\t学生性别\t学生年龄\t学生电话");
		for (Student s:sList) {
			System.out.println(s.getId()+"\t"+s.getStudent_code()+"\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getAge()+"\t"+s.getTel());
			System.out.println();
		}
	}
	//测试修改数据的方法
	public void updateTest() {
		StudentDao s1= new StudentDao();
		s1.updateStudent("xa004", "gwh");
	}
}
