package com.qa.moor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.moor.entities.EntityFactory;
import com.qa.moor.entities.GameEntity;
import com.qa.moor.entities.MagicalUnicorn;
import com.qa.moor.entities.Treasure;

public class EntityFactoryTest {

	private EntityFactory factory = EntityFactory.getInstance();

	@Test
	public void testCreateTreasure() {
		GameEntity testEntity = factory.genEntity("treasure", new Coordinates(44, 94));
		assertTrue(testEntity instanceof Treasure);
		assertEquals("103.79", testEntity.getDistance());
	}

	@Test
	public void testCreateUnicorn() {
		GameEntity testEntity = factory.genEntity("unicorn", new Coordinates(44, 94));
		assertTrue(testEntity instanceof MagicalUnicorn);
		assertEquals("103.79", testEntity.getDistance());
	}

}
