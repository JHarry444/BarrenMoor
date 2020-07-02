package com.qa.moor;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Game game = new Game(scanner, 20);
			game.play();
		}
	}

}
