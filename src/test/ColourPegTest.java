package test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import mastermind.Colour;
import mastermind.ColourPeg;
import mastermind.Tokeniser;

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

	@Test
	public void colourIsSetTest() {

		String expectedColour = "Green";
		Colour instance = new ColourPeg(expectedColour);
		String resultColour = instance.getColour();
		assertEquals(expectedColour, resultColour );
		
	}
	
	@Test
	public void tokenIsValidTest() {

		Character expectedToken = 'G';
		Tokeniser<Character> instance = new ColourPeg("Green");
		Character resultToken = instance.getToken();
		assertEquals(expectedToken, resultToken );
	}
	
	@Test
	public void tokenIsUniqueTest() {

		Tokeniser blue = new ColourPeg("blue");
		Tokeniser brown = new ColourPeg("brown");
		
		Set<Tokeniser> set = new HashSet<>();
		
		set.add(blue);
		set.add(brown);
		
		int expectedSize= 1;
		assertEquals(set.size(), expectedSize );
	}
}
