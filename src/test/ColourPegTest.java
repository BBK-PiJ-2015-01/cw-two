package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mastermind.Colour;
import mastermind.ColourPeg;

public class ColourPegTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void colourIsNotNullTest() {
		
		Colour instance = new ColourPeg();
		String resultColour = instance.getColour();
		assertNotNull(resultColour);
	}
	
	@Test
	public void colourIsNotEmptyTest() {
		
		Colour instance = new ColourPeg();
		String resultColour = instance.getColour();
		assertFalse(resultColour.isEmpty());
	}

}
