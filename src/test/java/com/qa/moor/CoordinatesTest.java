package com.qa.moor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoordinatesTest {

	private Coordinates coords = new Coordinates(4, 5);

	@Test
	public void testDistance() {
		assertEquals("6.4", this.coords.getDistance());
	}
}
