package mastermind;

import java.util.List;

public class GameStateImpl implements GameState {

	private List<?> solution;
	private GameStatus gameStatus;
	private String message;
	//
	private final String NULL_VALUE_MSG = "A null value is not allowed";

	@Override
	public List<?> getSolution() {

		return solution;
	}

	@Override
	public void setSolution(List<?> solution) {

		if (solution == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		this.solution = solution;
	}

	@Override
	public GameStatus getGameStatus() {

		return gameStatus;
	}

	@Override
	public void setGameStatus(GameStatus gameStatus) {

		if (gameStatus == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		this.gameStatus = gameStatus;
	}

	@Override
	public List<GameAttempt> getGameHistory() {

		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void addAttempt(GameAttempt attempt) {

		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public String getMessage() {

		return message;
	}

	@Override
	public void setMessage(String message) {

		this.message = message;
	}

}
