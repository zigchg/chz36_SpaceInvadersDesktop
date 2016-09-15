package edu.pitt.is1017.spaceinvaders;

import java.sql.SQLException;

public class TestUser {

	public static void main(String[] args) throws SQLException {
		User u = new User(23);
		u.saveUserInfo();
		
	}

}
