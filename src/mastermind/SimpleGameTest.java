package mastermind;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleGameTest {

	public static void main(String[] args) {

		new SimpleGameTest().runGame();

	}

	private void runGame() {

		GameDetails details = new GameDetailsImpl(12L, 4L, getTestGameValues());
		GameInstanceImpl theGame = new GameInstanceImpl(details);
		GameInputterImpl inputter = new GameInputterImpl();
		inputter.setGameValues(getTestGameValues());
		GameState state = theGame.getGameState();
		GameOutputter out = new GameOutputterImpl();
		OutputFormatter formatter = null;
		try {
			formatter = new OutputFormatterImpl(out);
		} catch (IOException e) {

			e.printStackTrace();
		}
		formatter.outputGameDetails(theGame);
		while (state.getGameStatus() == GameStatus.IN_PLAY) {

			formatter.outputAttemptPrompt(theGame);

			GameAttempt attempt = inputter.readAttempt();

			state = theGame.evaluateAttempt(attempt);
			List<GameAttempt> history = state.getGameHistory();
			AttemptResult lastAttempt = history.get(history.size() - 1).getAttemptResult();
			System.out.println(String.format("You got %d right and %d close", lastAttempt.getExactScore(),
					lastAttempt.getNearScore()));

		}

		System.out.println(theGame.getRemainingAttempts() == 0L ? "You lose" : "You WIN!");
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
