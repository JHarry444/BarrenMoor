package com.qa.moor;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.moor.utils.UserInput;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@InjectMocks
	private Game game;

	@Mock
	private UserInput input;

}
