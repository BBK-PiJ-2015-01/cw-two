package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import mastermind.ColourPeg;
import mastermind.GameAttempt;
import mastermind.GameCommand;
import mastermind.GameInputterImpl;
import mastermind.Tokeniser;

public class GameInputterTest {

	private PrintStream instanceOut;
	private PrintStream testOut;

	private InputStream instanceIn;
	private InputStream testIn;

	private GameInputterImpl instance;

	@Before
	public void setUp() throws Exception {

		PipedOutputStream pos1 = new PipedOutputStream();
		PipedOutputStream pos2 = new PipedOutputStream();

		instanceIn = new PipedInputStream(pos1);
		testIn = new PipedInputStream(pos2);

		instanceOut = new PrintStream(pos2);
		testOut = new PrintStream(pos1);

		instance = new GameInputterImpl(instanceIn);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setNullGameValuesTest() {

		instance.setGameValues(null);
	}

	@Test
	public void setEmptyGameValuesTest() {

		Set<Tokeniser<Character>> expectedValue = Collections.emptySet();
		instance.setGameValues(expectedValue);
		Set<Tokeniser<Character>> resultValue = instance.getGameValues();
		assertEquals(expectedValue, resultValue);
	}

	@Test
	public void setGameValuesTest() {

		Set<Tokeniser<Character>> expectedValue = getTestGameValues();
		instance.setGameValues(expectedValue);
		Set<Tokeniser<Character>> resultValue = instance.getGameValues();
		assertEquals(expectedValue, resultValue);
	}

	// **********************************************************************
	// Tests for game attempt
	// **********************************************************************

	@Test
	public void readAttemptTest() {

		instance.setGameValues(getTestGameValues());

		String testString = "GBRY";
		List<?> expectedGuess = Arrays.asList(new ColourPeg[] { new ColourPeg("Green"), new ColourPeg("Blue"),
				new ColourPeg("Red"), new ColourPeg("Yellow") });

		testOut.println(testString);

		GameAttempt result = instance.readAttempt();
		List<?> resultGuess = result.getAttempt();
		assertEquals(expectedGuess, resultGuess);

	}

	@Test
	public void readInvalidAttemptTest() {

		instance.setGameValues(getTestGameValues());

		String testString = "GBRU";
		List<?> expectedGuess = Arrays.asList(new ColourPeg[] { new ColourPeg("Green"), new ColourPeg("Blue"),
				new ColourPeg("Red"), new ColourPeg("Yellow") });

		testOut.println(testString);

		GameAttempt result = instance.readAttempt();
		List<?> resultGuess = result.getAttempt();
		assertNotEquals(expectedGuess, resultGuess);
	}

	// **********************************************************************
	// Tests for command
	// **********************************************************************
	@Test
	public void readValidGameCommandTest() {

		instance.setGameValues(getTestGameValues());

		String testString = ":X";
		GameCommand expectedCommand = GameCommand.EXIT;

		testOut.println(testString);

		GameCommand resultCommand = instance.getCommand();
		assertEquals(expectedCommand, resultCommand);
	}

	@Test
	public void readInvalidGameCommandTest() {

		instance.setGameValues(getTestGameValues());

		String testString = "Not a valid command";
		GameCommand expectedCommand = null;

		testOut.println(testString);

		GameCommand resultCommand = instance.getCommand();
		assertEquals(expectedCommand, resultCommand);
	}

	private Set<Tokeniser<Character>> getTestGameValues() {

		Set<Tokeniser<Character>> returnMap = new HashSet<>();
		returnMap.add(new ColourPeg("Green"));
		returnMap.add(new ColourPeg("Blue"));
		returnMap.add(new ColourPeg("Red"));
		returnMap.add(new ColourPeg("Yellow"));
		returnMap.add(new ColourPeg("Purple"));
		returnMap.add(new ColourPeg("Orange"));
		return returnMap;
	}
}
