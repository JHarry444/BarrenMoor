package com.qa.moor.entities;

import com.qa.moor.Coordinates;

public class MagicalUnicorn extends GameEntity {

	public MagicalUnicorn(Coordinates co_ords) {
		super(co_ords, false, "You encountered a magical unicorn! Isn't that nice?");
	}

	public MagicalUnicorn() {
		this(new Coordinates());
	}

}
