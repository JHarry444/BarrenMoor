package com.qa.moor.entities;

import com.qa.moor.Coordinates;

public class MagicalUnicorn extends GameEntity {

	public MagicalUnicorn(Coordinates location) {
		super(location, false, "You encountered a magical unicorn! Isn't that nice?");
	}

	public MagicalUnicorn() {
		this(new Coordinates());
	}

}
