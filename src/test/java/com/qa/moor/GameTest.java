package com.qa.moor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.moor.utils.UserInput;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@InjectMocks
	private Game game;

	@Mock
	private UserInput input;

	@Test
	public void testPlayAgain() {
		Mockito.when(this.input.getText()).thenReturn("y");
		assertTrue(this.game.playAgain());
		Mockito.verify(this.input, Mockito.times(1)).getText();
	}

	@Test
	public void testNotPlayAgain() {
		Mockito.when(this.input.getText()).thenReturn("n");
		assertFalse(this.game.playAgain());
		Mockito.verify(this.input, Mockito.times(1)).getText();
	}

}
