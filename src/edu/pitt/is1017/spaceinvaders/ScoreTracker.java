package edu.pitt.is1017.spaceinvaders;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class ScoreTracker {
	private User user;
	private int currentScore;
	private int highestScore;
	private String gameID;
	
	public ScoreTracker(User user){
		this.user = user;
		this.currentScore = 0;
		
		UUID id = UUID.randomUUID();
		gameID = String.valueOf(id);
				
		int userID = this.user.getUserID();
		String sql = "SELECT MAX(scoreValue) FROM finalscores WHERE fk_userID = " + userID;
		DbUtilities dbu = new DbUtilities();
		ResultSet rs = dbu.getResultSet(sql);
		try {
			if (rs.next()){
				this.highestScore = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbu.closeConnection();
	}
	
	public void recordScore (int point){
		this.currentScore += point;
		
		int scoreType = 0;		
		if (point == 1) scoreType=1;
		
		Date currentTime = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

		String dateTimeEntered = (ft.format(currentTime)).toString();
				
		String sql = "INSERT INTO runningscores (gameID, scoreType, scoreValue, fk_userID, dateTimeEntered) " + 
				"VALUES ('" + this.gameID + "', " + scoreType + ", " + this.currentScore + ", " + 
				this.user.getUserID() + ", '" + dateTimeEntered + "');";
		
		DbUtilities dbu = new DbUtilities();
		dbu.executeQuery(sql);
		dbu.closeConnection();
	}
	
	public void recordFinalScore(){
		
		Date currentTime = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

		String dateTimeEntered = (ft.format(currentTime)).toString();
		
		String sql = "INSERT INTO finalscores (gameID, scoreValue, fk_userID, dateTimeEntered) " + 
				"VALUEs ('" + this.gameID + "', " + this.currentScore + ", " + this.user.getUserID()
				+ ", '" + dateTimeEntered + "');";
		
		DbUtilities dbu = new DbUtilities();
		dbu.executeQuery(sql);
		dbu.closeConnection();
		
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public String getGameID() {
		return gameID;
	}

}
