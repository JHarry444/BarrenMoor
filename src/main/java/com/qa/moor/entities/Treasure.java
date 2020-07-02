package com.qa.moor.entities;

import com.qa.moor.Coordinates;

public class Treasure extends GameEntity {

	public Treasure(Coordinates co_ords) {
		super(co_ords, true, "You see a box sitting on the plain. It’s filled with treasure! You win! The end.");
	}

	public Treasure() {
		this(new Coordinates());
	}

}
