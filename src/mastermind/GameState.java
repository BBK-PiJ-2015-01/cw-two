package mastermind;

import java.util.List;

public interface GameState {
	
	List<?> getSolution(); 

	void setSolution(List<?> solution); 

	GameStatus getGameStatus(); 

	void setGameStatus(GameStatus gameStatus); 

	List<GameAttempt> getGameHistory(); 

	void addAttempt(GameAttempt attempt); 

	String getMessage(); 

	void setMessage(String message);
}
