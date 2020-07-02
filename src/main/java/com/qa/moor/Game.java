package com.qa.moor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.qa.moor.entities.EntityFactory;
import com.qa.moor.entities.GameEntity;
import com.qa.moor.entities.Treasure;

public class Game {

	private Scanner scanner;

	private Treasure treasure;

	private List<GameEntity> entities;

	private Random rand = new Random();

	private int size;

	private final boolean easy;

	public Game(Scanner scanner, int size) {
		this(scanner, size, false);
	}

	public Game(Scanner scanner, int size, boolean easy) {
		super();
		this.scanner = scanner;
		this.size = size;
		this.easy = easy;

		this.entities = new ArrayList<>();
	}

	private Coordinates genCoordinates() {
		Coordinates co_ords = new Coordinates();
		do {
			co_ords.setX(rand.nextInt(size) - (size / 2));
			co_ords.setY(rand.nextInt(size) - (size / 2));
		} while (co_ords.getDistance() == 0);
		return co_ords;
	}

	public GameEntity genEntity(String type) {
		Coordinates co_ords = this.genCoordinates();
		return EntityFactory.getInstance().genEntity(type, co_ords);
	}

	public void setup() {
		this.treasure = (Treasure) this.genEntity("treasure");
		this.entities.add(treasure);
		this.entities.add(this.genEntity("nick"));
		this.entities.add(this.genEntity("unicorn"));
	}

	public void play() {
		do {
			System.out.println(this.getIntro());
			this.setup();
			do {
				if (this.easy) {
					this.entities.forEach(System.out::println);
				}
				System.out.println("The dial reads '" + this.treasure.getDistance() + "'");

				this.move();
			} while (!gameOver());
		} while (this.playAgain());
		System.out.println(this.getOutro());
	}

	private boolean gameOver() {
		this.entities.stream().filter(entity -> entity.getDistance().equals("0"))
				.forEach(entity -> System.out.println(entity.getMessage()));
		return this.entities.stream().filter(entity -> entity.getDistance().equals("0"))
				.anyMatch(GameEntity::isGameOver);
	}

	private void updateCoords(int x, int y) {
		this.entities.forEach(entity -> entity.updateCoords(x, y));
	}

	private void move() {
		boolean valid = true;
		do {
			String response = this.getResponse().toLowerCase();
			switch (response) {
			case ("n"):
			case ("north"):
				this.updateCoords(0, -1);
				valid = true;
				break;
			case ("s"):
			case ("south"):
				this.updateCoords(0, +1);
				valid = true;
				break;
			case ("e"):
			case ("east"):
				this.updateCoords(-1, 0);
				valid = true;
				break;
			case ("w"):
			case ("west"):
				this.updateCoords(+1, 0);
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
