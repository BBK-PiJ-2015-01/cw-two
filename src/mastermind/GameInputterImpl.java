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
import mastermind.GameCommand;

public class GameInputterImpl implements GameInputter {

	// Stream to read from
	private InputStream in;
	// Default reader for the stream
	private BufferedReader reader;

	private Set<Tokeniser<Character>> gameValues;
	private Set<? extends Tokeniser<String>> commandValues = EnumSet.allOf(GameCommand.class);

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

	
	@Override
	public GameAttempt readAttempt() {

		GameAttempt result = new GameAttemptImpl();
		try {
			
			String s = reader.readLine();
			// Treat all input as a stream of characters
			s = s.replaceAll("\\s", "");
			
		

			List<Character> chars = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				chars.add(s.charAt(i));
			}
			System.out.println(chars + " was input");
			List<?> selectedTokens = mapTokenToObject(chars, gameValues);
			result.setAttempt(selectedTokens);
			
		} catch (IOException e) {

			e.printStackTrace();
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@Override
	public GameCommand getCommand() {

		GameCommand result = null;
		try {
			
			String s = reader.readLine();
			// Treat all input as a stream of characters
			s = s.trim();

			List<Character> chars = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				chars.add(s.charAt(i));
			}

			List<?> selectedTokens = mapTokenToObject(Arrays.asList(new String[]{s}), commandValues);
			result = selectedTokens.isEmpty() ? null : (GameCommand) selectedTokens.get(0);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	//
	// Helper method to translate Chars to ColourPegs
	//
	private List<?> mapTokenToObject(Collection<?> input, Set<? extends Tokeniser<?>> tokens) {

		String NULL_ARG_MESSAGE = "Null arguments are not allowed";

		Objects.requireNonNull(input, NULL_ARG_MESSAGE);
		Objects.requireNonNull(tokens, NULL_ARG_MESSAGE);

		if (input.isEmpty() || tokens.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List<Tokeniser<?>> returnList = new LinkedList<>();
		for(Object i : input) {
			for (Tokeniser<?> token : tokens) {
				if (token.getToken().equals(i)) {
					returnList.add(token);
				}
			}
		}
		return returnList;
	}


}
