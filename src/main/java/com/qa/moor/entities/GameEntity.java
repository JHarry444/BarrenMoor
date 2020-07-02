package com.qa.moor.entities;

import java.text.DecimalFormat;

import com.qa.moor.Coordinates;

public abstract class GameEntity {

	private final Coordinates co_ords;

	private final boolean gameOver;

	private final String message;

	private static final DecimalFormat formatter = new DecimalFormat("#.##");

	public GameEntity(Coordinates co_ords, boolean gameOver, String message) {
		super();
		this.co_ords = co_ords;
		this.gameOver = gameOver;
		this.message = message;
	}

	public void updateCoords(int x, int y) {
		this.co_ords.setX(this.co_ords.getX() + x);
		this.co_ords.setY(this.co_ords.getY() + y);
	}

	public String getDistance() {
		return formatter.format(this.co_ords.getDistance());
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "GameEntity [co_ords=" + co_ords + ", gameOver=" + gameOver + ", message=" + message + "]";
	}

}
