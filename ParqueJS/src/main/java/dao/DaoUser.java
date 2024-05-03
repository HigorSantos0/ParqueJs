package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class DaoUser {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public DaoUser(Connection con) {
		this.con = con;
	}
	
	public User userLogin( String nome, String email, String password) {
		User user = null;
		
		try {
			query = "SELECT * FROM usuario WHERE email=? AND password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, nome);
			pst.setString(2, email);
			pst.setString(3, password);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User();
			
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return user;
	}
	
	
	public boolean addUser(User user) {
	    try {
	        query = "INSERT INTO usuario (name, email, password) VALUES (?, ?, ?)"; 
	        pst = this.con.prepareStatement(query);
	        pst.setString(1, user.getNome()); 
	        pst.setString(2, user.getEmail());
	        pst.setString(3, user.getPassword());

	        int rowsInserted = pst.executeUpdate();
	        return rowsInserted > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        return false;
	    } finally {
	       
	    }
	}
	

}
