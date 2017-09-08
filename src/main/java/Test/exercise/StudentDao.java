package Test.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class StudentDao implements DaoImpl {
	//向数据库中添加数据
	@SuppressWarnings("unused")
	public void addStudent(String Student_code,String name,String gender,int age,int tel) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn = JDBCTool.getCon();//建立数据库连接
			String sql = "insert into lizhao(Student_code,name,gender,age,tel) values ('"+Student_code+"','"+name+"','"+gender+"','"+age+"','"+tel+"')";
			PreparedStatement stmt = conn.prepareStatement(sql);//会抛出异常
			stmt.executeUpdate();  //执行插入操作
			System.out.println("插入数据成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} finally { 
				try {
				conn.close(); 
				} catch(SQLException e) {
				e.printStackTrace();
				}
			}
		System.out.println("Goodbye!");
	}
	//删除数据库中的数据
	public void deleteStudent(String Student_code) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JDBCTool.getCon();//建立数据库连接 
			String sql = "delete from lizhao where Student_code = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);//会抛出异常
			stmt.setString(1, Student_code);
			stmt.executeUpdate();
			System.out.println("删除成功");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
	//查询数据库中数据
	public List<Student> findStudent() {
		// TODO Auto-generated method stub
		List<Student> sList = new ArrayList<Student>();
		Connection conn = null;
		try {
			conn = JDBCTool.getCon();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from lizhao");
			while (rs.next()) {
				Student s =new Student();
				s.setStudent_code(rs.getString("Student_code"));
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setTel(rs.getInt("tel"));
				sList.add(s);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return  sList;
	}
	//更改数据库中数据
	public void updateStudent(String Student_code,String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JDBCTool.getCon();
			String sql = "update lizhao set name=? where Student_code = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, Student_code);
			stmt.executeUpdate();//执行修改操作
			System.out.println("姓名修改成功");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}
