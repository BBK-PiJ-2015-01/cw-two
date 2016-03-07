package mastermind;

import java.util.Collections;

public class GameInstanceImpl implements GameInstance {

	private final GameDetails gameDetails;
	private final GameState gameState;
	
	Long attemptCounter = 0L;
	
	
	
	public GameInstanceImpl(GameDetails gameDetails) {
		super();
		this.gameDetails = gameDetails;
		gameState = new GameStateImpl();
		gameState.setSolution(Collections.EMPTY_LIST);
	}

	@Override
	public GameState evaluateAttempt(GameAttempt attempt) {

		attemptCounter++;
		return null;
	}

	@Override
	public GameState getGameState() {
		// TODO Auto-generated method stub
		return gameState;
	}

	@Override
	public GameDetails getGameDetails() {

		return gameDetails;
	}

	@Override
	public Long getRemainingAttempts() {

		return gameDetails.getNumberOfAttempts() - attemptCounter;
	}
}
