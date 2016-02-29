package mastermind;

import java.util.LinkedList;
import java.util.List;

public class GameStateImpl implements GameState {

	private List<?> solution;
	private GameStatus gameStatus;
	private List<GameAttempt> gameHistory = new LinkedList<>();
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

		return gameHistory;
	}

	@Override
	public void addAttempt(GameAttempt attempt) {

		if (attempt == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		gameHistory.add(attempt);
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
