package mastermind;

import java.io.IOException;

public class MastermindDriver {

	private GameDetailsFactory gameFactory;
	private GameInputterFactory inputterFactory;

	// Example - change as you need to...
	public static void main(String[] args) {
		// Game g = Factory.getInstance(Game.class, true);
		// g.runGames();

		// g = Factory.getInstance(Game.class, false);
		// g.runGames();

		new MastermindDriver().runGame(false);
	}

	private void runGame(boolean easy) {

		final String gameType = "simpleColours";
		
		gameFactory = new MastermindGameFactory();
		inputterFactory = (GameInputterFactory) gameFactory;

		GameInstance theGame = getGameInstance(gameType);
		GameInputter inputter = getGameInputter(gameType);
		
		GameOutputter out = new GameOutputterImpl();

		OutputFormatter formatter = null;
		try {
			formatter = new OutputFormatterImpl(out);
		} catch (IOException e) {

			e.printStackTrace();
		}
		formatter.outputGameDetails(theGame);

		GameState state = theGame.getGameState();

		GameCommand command = GameCommand.NEW_GAME;

		while (command != GameCommand.EXIT) { // Until player wants to stop
												// playing

			while (state.getGameStatus() == GameStatus.IN_PLAY) { // while game
																	// in play

				if (easy) {
					formatter.outputSolution(theGame);
				}

				// Prompt for an attempt
				formatter.outputAttemptPrompt(theGame);

				// Read an attempt
				GameAttempt attempt = inputter.readAttempt();

				// evaluate the attempt
				state = theGame.evaluateAttempt(attempt);

				// Show the game history
				formatter.outputGameHistory(theGame);

				switch (state.getGameStatus()) {

				case SOLVED:
					formatter.outputSuccessMessage(theGame);
					break;
				case EXPIRED:
					formatter.outputFailedMessage(theGame);
					break;
				default:
				}

			}
			// Get the next command
			GameCommand nextCommand = null;
			while (nextCommand == null) {
				// Prompt..
				formatter.outputCommandPrompt(theGame);
				// .. read
				nextCommand = inputter.getCommand();
				theGame = getGameInstance(gameType);
				state = theGame.getGameState();
			}
			command = nextCommand;
		}
		formatter.outputFinalMessage();
	}

	private GameInstanceImpl getGameInstance(String gameType) {

		return gameFactory.getGameInstance(gameType);
	}

	private GameInputter getGameInputter(String gameType) {
		
		return inputterFactory.getGameInputter(gameType);
	}

}
