package com.qa.moor.entities;

import com.qa.moor.Coordinates;

public class EntityFactory {

	public static GameEntity genEntity(String type, Coordinates co_ords) {
		switch (type.strip().toLowerCase()) {
		case "treasure":
			return new Treasure(co_ords);
		case "nick":
			return new Nick(co_ords);
		case "unicorn":
			return new MagicalUnicorn(co_ords);
		default:
			return null;
		}
	}

}