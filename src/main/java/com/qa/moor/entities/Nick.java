package com.qa.moor.entities;

import com.qa.moor.Coordinates;

public class Nick extends GameEntity {

	public Nick(Coordinates co_ords) {
		super(co_ords, true, "You've been eaten by a Nick! What a weapon.");
	}

	public Nick() {
		this(new Coordinates());
	}

}
