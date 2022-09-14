package com.qa.moor.utils;

import java.io.Closeable;
import java.util.Scanner;

public class UserInput implements Closeable {

	private final Scanner scan;

	public UserInput(Scanner scan) {
		super();
		this.scan = scan;
	}

	public String getText() {
		return this.scan.nextLine();
	}

	@Override
	public void close() {
		this.scan.close();
	}

}
