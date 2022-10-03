package com.qa.moor;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.moor.utils.UserInput;

@RunWith(MockitoJUnitRunner.class)
public class UserInputTest {

	@InjectMocks
	private UserInput input;

	@Mock
	private Scanner scan;

	@Test
	public void testGetString() {
		final String testString = "Testing123";
		Mockito.when(this.scan.nextLine()).thenReturn(testString);
		assertEquals(testString, this.input.getText());

		Mockito.verify(this.scan, Mockito.times(1)).nextLine();
	}
}
