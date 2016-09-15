package edu.pitt.is1017.spaceinvaders;

import java.sql.SQLException;

public class TestScoreTracker {

	public static void main(String[] args) throws SQLException {
		User user = new User("chz36@pitt.edu", "123");
		//System.out.println(user.getUserID());
		ScoreTracker st = new ScoreTracker(user);
		//st.recordScore(45);
		st.recordFinalScore();
	}

}
