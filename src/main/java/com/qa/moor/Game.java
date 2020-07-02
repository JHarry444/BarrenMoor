package com.qa.moor;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private Scanner scanner;

	private Coordinates co_ords;

	private Random rand = new Random();

	private DecimalFormat formatter = new DecimalFormat("#.##");

	private int size;

	public Game(Scanner scanner, int size) {
		super();
		this.scanner = scanner;
		this.size = size;
	}

	public Coordinates genCoordinates() {
		Coordinates co_ords = new Coordinates();
		co_ords.setX(rand.nextInt(size) - (size / 2));
		co_ords.setY(rand.nextInt(size) - (size / 2));
		return co_ords;
	}

	public void play() {
		do {
			System.out.println(this.getIntro());
			this.co_ords = this.genCoordinates();
			do {
				System.out.println("The dial reads '" + this.formatter.format(this.co_ords.getDistance()) + "'");
				this.move();
			} while (this.co_ords.getDistance() > 0);
			System.out.println(this.victory());
		} while (this.playAgain());
		System.out.println(this.getOutro());
	}

	private String victory() {
		return "You see a box sitting on the plain. It’s filled with treasure! You win! The end.";
	}

	private void move() {
		boolean valid = true;
		do {
			String response = this.getResponse().toLowerCase();
			switch (response) {
			case ("n"):
			case ("north"):
				this.co_ords.setY(this.co_ords.getY() - 1);
				valid = true;
				break;
			case ("s"):
			case ("south"):
				this.co_ords.setY(this.co_ords.getY() + 1);
				valid = true;
				break;
			case ("e"):
			case ("east"):
				this.co_ords.setX(this.co_ords.getX() - 1);
				valid = true;
				break;
			case ("w"):
			case ("west"):
				this.co_ords.setX(this.co_ords.getX() + 1);
				valid = true;
				break;
			default:
				System.out.println("Please enter 'North', 'South', 'East' or 'West'");
				valid = false;
			}
		} while (!valid);
	}

	private String getOutro() {
		return "Thanks for playing!";
	}

	public boolean playAgain() {
		System.out.println("Would you like to play again? Y/N");
		String response = getResponse();
		return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");
	}

	public String getResponse() {
		String response = this.scanner.nextLine();
		return response;
	}

	public String getIntro() {
		return "Grey foggy clouds float oppressively close to you, \n"
				+ "reflected in the murky grey water which reaches up your shins.\n"
				+ "Some black plants barely poke out of the shallow water.\n"
				+ "Try \"north\", \"south\", \"east\", or \"west\"\n"
				+ "You notice a small watch-like device in your left hand.  \n"
				+ "It has hands like a watch, but the hands don't seem to tell time.\n";
	}
}
