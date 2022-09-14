package com.qa.moor.entities;

import com.qa.moor.Coordinates;

public class EntityFactory {

	private EntityFactory() {
		super();
	}

	public static final EntityFactory INSTANCE = new EntityFactory(); // eagerly initialised

	public static EntityFactory getInstance() {
		return INSTANCE;
	}

	public GameEntity genEntity(String type, Coordinates co_ords) {
		switch (type.strip().toLowerCase()) {
		case "treasure":
			return new Treasure(co_ords);
		case "unicorn":
			return new MagicalUnicorn(co_ords);
		default:
			return null;
		}
	}

}
