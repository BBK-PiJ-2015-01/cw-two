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

	@Test(expected = IllegalArgumentException.class)
	public void colourIsNotNullTest() {

		new ColourPeg(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void colourIsNotEmptyTest() {

		new ColourPeg("");
	}

}
