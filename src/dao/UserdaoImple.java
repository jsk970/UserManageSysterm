package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Jdbc;
import util.Jdbc;
import bean.User;

public class UserdaoImple implements Userdao {
	public User Login(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("SELECT * FROM usermanagesystem WHERE name=?");
			psd.setString(1, name);
			rs = psd.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPower(rs.getInt("power"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			Jdbc.close(conn,  psd, rs);
		}
		return user;
	}

	@Override
	public int Update(int id,String name, String password,String email) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		int up = 0;
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("update usermanagesystem Set name=?,password=?,email=? where id=?");
			
			psd.setString(1, name);
			psd.setString(2, password);
			psd.setString(3, email);
			psd.setLong(4,id );
			up = psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return up;
	}

	@Override
	public int MUpdate(int id, String name, String password, String email) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		int up = 0;
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("update usermanagesystem Set name=?,password=?,email=? where id=?");
			
			psd.setString(1, name);
			psd.setString(2, password);
			psd.setString(3, email);
			psd.setLong(4,id );
			up = psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return up;
	}
	@Override
	public User IDSelect(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("SELECT * FROM usermanagesystem WHERE id=?");
			psd.setLong(1, id);
			rs = psd.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPower(rs.getInt("power"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jdbc.close(conn,  psd, rs);
		}
		return user;
	}

	@Override
	public ArrayList<User> AllSelect() {
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		ArrayList<User> array = new ArrayList<User>(); 
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("SELECT * FROM usermanagesystem");
			
			rs = psd.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPower(rs.getInt("power"));
				array.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jdbc.close(conn,  psd, rs);
		}
		return array;
	}
	public ArrayList<String> SameEmail()
	{
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		ArrayList<String> array = new ArrayList<String>(); 
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("SELECT * FROM usermanagesystem");
			
			rs = psd.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPower(rs.getInt("power"));
				array.add(user.getEmail());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jdbc.close(conn,  psd, rs);
		}
		return array;
	}
	public ArrayList<User> SimilarSelect(String same) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		ArrayList<User> array = new ArrayList<User>();
		try {
			conn = Jdbc.getConnection();
			psd = (PreparedStatement)
			conn.prepareStatement("SELECT * FROM usermanagesystem where name like '%"+same+"%'");
			rs = psd.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPower(rs.getInt("power"));
				array.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jdbc.close(conn,  psd, rs);
		}
		return array;
		
	}

	@Override
	public int AddUser(String name, String password, String email) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		int up = 0;
			try {
				conn = Jdbc.getConnection();
				psd = (PreparedStatement)
				conn.prepareStatement("insert into usermanagesystem(name,password,email) values(?,?,?)");
				
				  psd.setString(1, name);
				  psd.setString(2, password);
				  psd.setString(3, email);
				  up = psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return up;
	}

	@Override
	public int DeleteUser(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psd = null;
		User user = null;
		ResultSet rs = null;
		int up = 0;
			try {
				conn = Jdbc.getConnection();
				psd = (PreparedStatement)
				conn.prepareStatement("delete from usermanagesystem where id=?");
				  psd.setLong(1, id);
				  up = psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return up;
	}

}

