package com.qa.moor;

import java.util.Scanner;

import com.qa.moor.utils.UserInput;

public class App {

	public static void main(String[] args) {
		try (UserInput input = new UserInput(new Scanner(System.in))) {
			Game game = new Game(input, 20);
			game.play();
		}
	}

}
