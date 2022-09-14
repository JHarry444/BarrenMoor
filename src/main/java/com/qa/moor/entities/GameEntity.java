package com.qa.moor.entities;

import java.text.DecimalFormat;

import com.qa.moor.Coordinates;

public abstract class GameEntity {

	private final Coordinates location;

	private final boolean gameOver;

	private final String message;

	private static final DecimalFormat formatter = new DecimalFormat("#.##");

	public GameEntity(Coordinates location, boolean gameOver, String message) {
		super();
		this.location = location;
		this.gameOver = gameOver;
		this.message = message;
	}

	public void updateCoords(int x, int y) {
		this.location.setX(this.location.getX() + x);
		this.location.setY(this.location.getY() + y);
	}

	public String getDistance() {
		return formatter.format(this.location.getDistance());
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "GameEntity [location=" + location + ", gameOver=" + gameOver + ", message=" + message + "]";
	}

}
