package com.qa.moor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.qa.moor.entities.EntityFactory;
import com.qa.moor.entities.GameEntity;
import com.qa.moor.entities.Treasure;
import com.qa.moor.utils.UserInput;

public class Game {

	private UserInput input;

	private Treasure treasure;

	private List<GameEntity> entities;

	private Random rand = new Random();

	private int size;

	private final boolean easy;

	public Game() {
		super();
		easy = false;
	}

	public Game(UserInput input, int size) {
		this(input, size, false);
	}

	public Game(UserInput input, int size, boolean easy) {
		super();
		this.input = input;
		this.size = size;
		this.easy = easy;

		this.entities = new ArrayList<>();
	}

	private Coordinates genCoordinates() {
		Coordinates location = new Coordinates();
		do {
			location.setX(rand.nextInt(size) - (size / 2));
			location.setY(rand.nextInt(size) - (size / 2));
		} while (location.getDistance() == 0);
		return location;
	}

	public GameEntity genEntity(String type) {
		Coordinates location = this.genCoordinates();
		return EntityFactory.getInstance().genEntity(type, location);
	}

	public void setup() {
		this.treasure = (Treasure) this.genEntity("treasure");
		this.entities.add(treasure);
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
			String response = this.input.getText().toLowerCase();
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
		String response = this.input.getText();
		return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");
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
