package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
* A GameInputter handles the conversion of user input
* 
* A GameInputter handles the conversion of user input into choice entities
* or game commands
*
*@author Simon Baird & Johannes Neethling
*/

public class GameInputterImpl implements GameInputter {

	// Stream to read from
	private InputStream in;
	// Default reader for the stream
	private BufferedReader reader;

	private Set<Tokeniser<Character>> gameValues;
	private Set<? extends Tokeniser<String>> commandValues = EnumSet.allOf(GameCommand.class);
	//
	private final Predicate<? super Tokeniser<?>> nullsPredicate = t -> t != null;

	public GameInputterImpl() {

		this(System.in);
	}

	public GameInputterImpl(InputStream in) {

		this.in = in;
		reader = new BufferedReader(new InputStreamReader(this.in));
	}

	public Set<Tokeniser<Character>> getGameValues() {
		return gameValues;
	}

	public void setGameValues(Set<Tokeniser<Character>> gameValues) {

		if (gameValues == null) {
			throw new IllegalArgumentException();
		}
		this.gameValues = gameValues;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public GameAttempt readAttempt() {

		GameAttempt result = new GameAttemptImpl();
		try {
			
			String s = reader.readLine();
			// Treat all input as a stream of characters
			s = s.replaceAll("\\s", "");
			
			// Collect the string characters into a list
	        List<?> chars = s.toUpperCase().chars().mapToObj(i -> Character.valueOf((char) i))
	                .collect(Collectors.toList());

	        // Map the character list to a list of tokens, in this case game pegs
			List<?> selectedTokens = mapTokenToObject(chars, gameValues);
			result.setAttempt(selectedTokens);
			
		} catch (IOException e) {

			e.printStackTrace();
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public GameCommand getCommand() {

		GameCommand result = null;
		try {
			
			String s = reader.readLine();			
			s = s.trim();
			// Use the supplied string to map to a command
			List<?> selectedTokens = mapTokenToObject(Arrays.asList(new String[]{s}), commandValues);
			result = selectedTokens.isEmpty() ? null : (GameCommand) selectedTokens.get(0);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	//
	// Helper method to translate to tokens.
	//
	private List<?> mapTokenToObject(Collection<?> input, Set<? extends Tokeniser<?>> tokens) {

		String NULL_ARG_MESSAGE = "Null arguments are not allowed";

		Objects.requireNonNull(input, NULL_ARG_MESSAGE);
		Objects.requireNonNull(tokens, NULL_ARG_MESSAGE);

		if (input.isEmpty() || tokens.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
        // Map the input string to available tokens
        return input.stream()
                .map(c -> tokens.stream().filter(token -> token.getToken().equals(c)).findAny().orElse(null))
                .filter(nullsPredicate).collect(Collectors.toList());
	}
}
